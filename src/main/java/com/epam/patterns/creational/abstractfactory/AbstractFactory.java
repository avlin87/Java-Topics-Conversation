package com.epam.patterns.creational.abstractfactory;

import com.epam.patterns.creational.abstractfactory.enums.VehicleType;
import com.epam.patterns.creational.abstractfactory.vehiclefactoryimpl.BikeFactory;
import com.epam.patterns.creational.abstractfactory.vehiclefactoryimpl.CarFactory;

/**
 * The Abstract Factory pattern is used when you want to create families of related objects
 * without specifying their concrete classes.
 * <p>
 * Why use the Abstract Factory Pattern?
 * - Decouples object creation: You don’t need to know the exact classes to instantiate (e.g., CarEngine or BikeEngine).
 * The factory hides this complexity.
 * - Ensures related objects are used together: Using the car factory ensures you’ll always get a CarEngine and CarTire,
 * preventing mismatched objects (e.g., BikeEngine with CarTire).
 * - Extensibility: Adding new factories (e.g., a TruckFactory) is straightforward and doesn’t require you to change
 * existing code.
 */
public class AbstractFactory {

    private VehicleFactory factory;

    public static void main(String[] args) {
        new AbstractFactory().example();
    }

    private void example() {
        VehicleType vehicleType = VehicleType.CAR;
        selectFactory(vehicleType);

        // Use the factory to create the objects
        Engine engine = factory.createEngine();
        Tire tire = factory.createTire();

        // See the created objects
        engine.showEngine(); // Output: Car Engine created!
        tire.showTire();     // Output: Car Tire created!
    }

    private void selectFactory(VehicleType vehicleType) {
        factory = switch (vehicleType) {
            case CAR -> new CarFactory();
            case BIKE -> new BikeFactory();
        };
    }
}
