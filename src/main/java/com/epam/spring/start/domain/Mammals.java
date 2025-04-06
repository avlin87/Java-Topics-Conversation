package com.epam.spring.start.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Mammals {
    private int age;

    protected abstract void drinkMilk();

    protected void hide() {
        System.out.println("Mammal is Hiding");
    }

}
