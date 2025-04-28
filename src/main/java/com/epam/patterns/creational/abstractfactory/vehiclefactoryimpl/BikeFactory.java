package com.epam.patterns.creational.abstractfactory.vehiclefactoryimpl;

import com.epam.patterns.creational.abstractfactory.Engine;
import com.epam.patterns.creational.abstractfactory.Tire;
import com.epam.patterns.creational.abstractfactory.VehicleFactory;
import com.epam.patterns.creational.abstractfactory.engineimpl.BikeEngine;
import com.epam.patterns.creational.abstractfactory.tireimpl.BikeTire;

public class BikeFactory implements VehicleFactory {

    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }

    @Override
    public Tire createTire() {
        return new BikeTire();
    }
}
