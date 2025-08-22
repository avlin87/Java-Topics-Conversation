package com.epam.annotations;

import com.epam.annotations.enums.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CurrentUser {

    private static final ThreadLocal<Set<Role>> ROLES = ThreadLocal.withInitial(HashSet::new);

    public static void loginWithRoles(Role... roles) {
        ROLES.get().clear();
        ROLES.get().addAll(Arrays.asList(roles));
    }

    public static boolean hasRole(Role  role) {
        return ROLES.get().contains(role);
    }

    public static void clear() {
        ROLES.remove();
    }
}

