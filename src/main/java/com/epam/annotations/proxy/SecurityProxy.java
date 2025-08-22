package com.epam.annotations.proxy;

import com.epam.annotations.CurrentUser;
import com.epam.annotations.annotation.RequiresRole;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Proxy is the class from the Java Reflection API (java.lang.reflect.Proxy)
 * that lets you create dynamic proxy objects (fake object) at runtime for an interface.
 * <p>
 * When you call a method on this proxy:
 * * The call doesn’t go straight to the real object.
 * Instead, it goes through a handler, where you can run extra logic (check annotations, log, secure, etc.).
 * Then you can decide to call the real object or block it.
 */
@Slf4j
public final class SecurityProxy {

    /**
     * Wraps a given object with a dynamic proxy that checks {@link RequiresRole} annotations.
     * <p>
     * Any method calls on the returned proxy are intercepted. If the method
     * (on the interface or the implementation) has a {@code @RequiresRole} annotation,
     * the current user's roles are verified before the real method is called.
     * If the user does not have the required role, a {@link SecurityException} is thrown.
     * </p>
     *
     * @param target               the real object whose methods should be secured
     * @param implementedInterface the interface that the proxy should implement
     * @param <T>                  the type of the interface
     * @return a proxy object that implements {@code implementedInterface} and enforces role checks
     * @throws SecurityException if a method is called without the required role
     */
    @SuppressWarnings("unchecked")
    public static <T> T secure(T target, Class<T> implementedInterface) {
        log.info("Entering secure({}, {})", target, implementedInterface);
        T proxyInstance = (T) Proxy.newProxyInstance(
                implementedInterface.getClassLoader(),
                getInterfaces(implementedInterface),
                getInvocationHandler(target)
        );
        log.info("Exiting  secure({})", proxyInstance);
        return proxyInstance;
    }

    /**
     * Returns the list of interfaces the proxy should implement.
     * <p>
     * We pass this to
     * {@link java.lang.reflect.Proxy#newProxyInstance(java.lang.ClassLoader,
     * java.lang.Class[],
     * java.lang.reflect.InvocationHandler)}
     * so the JVM can generate a runtime class that implements exactly this interface.
     *
     * @param implementedInterface the single interface the proxy will implement
     * @param <T>                  the interface type
     * @return an array containing only {@code implementedInterface}
     */
    private static <T> Class<?>[] getInterfaces(Class<T> implementedInterface) {
        return new Class<?>[]{implementedInterface};
    }

    /**
     * Builds the {@link InvocationHandler} that intercepts all method calls on the proxy.
     * <p>
     * Flow per call:
     * <ol>
     *   <li>Find the matching method on the real target object.</li>
     *   <li>Check for {@link RequiresRole} on the impl method (then on the interface method).</li>
     *   <li>If present, verify the current user has the required role; otherwise throw.</li>
     *   <li>Invoke the real method on {@code target} and return its result.</li>
     * </ol>
     *
     * @param target the real object that will receive allowed method calls
     * @param <T>    the target type
     * @return an {@code InvocationHandler} enforcing role checks before delegation
     */
    private static <T> InvocationHandler getInvocationHandler(T target) {
        return new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // Look for annotation on method of provided object first
                Method methodFromClass = target.getClass().getMethod(method.getName(), method.getParameterTypes());
                RequiresRole annotation = methodFromClass.getAnnotation(RequiresRole.class);
                if (Objects.isNull(annotation)) {
                    //if not found on object then look on interface method
                    annotation = method.getAnnotation(RequiresRole.class);
                }
                validateRole(annotation);
                return methodFromClass.invoke(target, args);
            }

            /**
             * This method separated just to justify usage of Anonymous class
             */
            private void validateRole(RequiresRole annotation) {
                if (Objects.nonNull(annotation) && !CurrentUser.hasRole(annotation.value())) {
                    throw new SecurityException("Access denied: requires role " + annotation.value());
                }
            }
        };
    }
}
