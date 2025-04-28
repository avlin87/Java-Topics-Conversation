package com.epam.patterns.creational.abstractfactory.engineimpl;

import com.epam.patterns.creational.abstractfactory.Engine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BikeEngine implements Engine {

    @Override
    public void showEngine() {
        log.info("Bike Engine created!");
    }
}
