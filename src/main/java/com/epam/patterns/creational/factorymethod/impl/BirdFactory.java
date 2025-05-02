package com.epam.patterns.creational.factorymethod.impl;

import com.epam.patterns.creational.factorymethod.Animal;
import com.epam.patterns.creational.factorymethod.AnimalFactory;

public class BirdFactory extends AnimalFactory {
    @Override
    protected Animal createAnimal() {
        return new Bird();
    }
}
