package com.epam.patterns.creational.abstractfactory;

public interface VehicleFactory {
    Engine createEngine();
    Tire createTire();
}
