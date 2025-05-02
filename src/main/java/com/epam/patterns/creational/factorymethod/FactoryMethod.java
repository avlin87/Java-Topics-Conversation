package com.epam.patterns.creational.factorymethod;

import com.epam.patterns.creational.factorymethod.enums.AnimalSpecie;
import com.epam.patterns.creational.factorymethod.impl.BirdFactory;
import com.epam.patterns.creational.factorymethod.impl.CatFactory;
import com.epam.patterns.creational.factorymethod.impl.DogFactory;

/**
 * You have a factory method that creates objects, but you let subclasses decide what type of object to create.
 * <p>
 * Why use the Factory Method Pattern?
 * - Decouple object creation: The client doesn’t directly create objects.
 * Instead, it depends on factories, making the code more flexible.
 * - Promotes code reusability: You can extend factories (subclasses) without changing the client code.
 * - Open-closed principle: Adding new product types doesn't require modifying existing code.
 */
public class FactoryMethod {

    private AnimalFactory factory;

    public static void main(String[] args) {
        new FactoryMethod().example();
    }

    private void example() {
        AnimalSpecie specie = AnimalSpecie.BIRD; // Change to "Cat" to test CatFactory
        selectFactory(specie);

        // Create the animal using the factory
        Animal animal = factory.createAnimal();

        // Use the created animal
        animal.speak(); // Output: "Woof! I'm a Dog." OR "Meow! I'm a Cat."
    }

    private void selectFactory(AnimalSpecie specie) {
        factory = switch (specie) {
            case CAT -> new CatFactory();
            case DOG -> new DogFactory();
            case BIRD -> new BirdFactory();
        };
    }
}
