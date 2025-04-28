package com.epam.patterns.creational.abstractfactory.tireimpl;

import com.epam.patterns.creational.abstractfactory.Tire;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarTire implements Tire {

    @Override
    public void showTire() {
        log.info("Car Tire created!");
    }
}