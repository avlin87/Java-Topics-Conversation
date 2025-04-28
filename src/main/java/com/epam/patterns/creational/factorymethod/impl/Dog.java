package com.epam.patterns.creational.factorymethod.impl;

import com.epam.patterns.creational.factorymethod.Animal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog implements Animal {

    @Override
    public void speak() {
        log.info("Woof! I'm a Dog.");
    }
}
