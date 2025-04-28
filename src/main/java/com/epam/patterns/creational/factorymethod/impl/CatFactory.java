package com.epam.patterns.creational.factorymethod.impl;

import com.epam.patterns.creational.factorymethod.Animal;
import com.epam.patterns.creational.factorymethod.AnimalFactory;

public class CatFactory extends AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
