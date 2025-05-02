package com.epam.patterns.creational.factorymethod.impl;

import com.epam.patterns.creational.factorymethod.Animal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bird implements Animal {

    @Override
    public void speak() {
        log.info("Bird speak");
    }
}
