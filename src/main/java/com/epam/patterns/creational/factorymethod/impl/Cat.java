package com.epam.patterns.creational.factorymethod.impl;

import com.epam.patterns.creational.factorymethod.Animal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat implements Animal {

    @Override
    public void speak() {
        log.info("Meow! I'm a Cat.");
    }
}