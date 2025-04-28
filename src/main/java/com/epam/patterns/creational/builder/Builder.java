package com.epam.patterns.creational.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * Why?
 * Constructors start becoming messy due to too many arguments.
 * So we use Builder to be able to read code and reduce error possibility.
 */
@Slf4j
public class Builder {

    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .addSize("Large")
                .addCheese(true)
                .addPepperoni(false)
                .build();
        log.info(pizza.toString());
    }
}