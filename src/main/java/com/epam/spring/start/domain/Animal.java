package com.epam.spring.start.domain;


public interface Animal {
    void run();

    void sleep();

    void eat();

    default void eat(Animal animal) {
        System.out.println(animal + " is eating");
    }
}
