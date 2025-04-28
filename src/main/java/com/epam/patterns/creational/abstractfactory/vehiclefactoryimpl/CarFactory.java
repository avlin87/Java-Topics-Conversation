package com.epam.patterns.creational.abstractfactory.vehiclefactoryimpl;

import com.epam.patterns.creational.abstractfactory.Engine;
import com.epam.patterns.creational.abstractfactory.Tire;
import com.epam.patterns.creational.abstractfactory.VehicleFactory;
import com.epam.patterns.creational.abstractfactory.engineimpl.CarEngine;
import com.epam.patterns.creational.abstractfactory.tireimpl.CarTire;

public class CarFactory implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Tire createTire() {
        return new CarTire();
    }
}