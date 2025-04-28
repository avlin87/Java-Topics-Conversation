package com.epam.patterns.creational.abstractfactory.tireimpl;

import com.epam.patterns.creational.abstractfactory.Tire;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BikeTire implements Tire {

    @Override
    public void showTire() {
        log.info("Bike Tire created!");
    }
}
