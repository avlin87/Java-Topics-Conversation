package com.epam.spring.start.domain.iml;

import com.epam.spring.start.domain.Animal;

public class Bob extends Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("Bob eat");
    }
}
