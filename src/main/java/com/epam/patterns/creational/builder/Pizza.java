package com.epam.patterns.creational.builder;

import lombok.Data;

@Data
public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;

    // Private constructor to enforce object creation through the Builder
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
    }

    // Builder (static nested class)
    public static class PizzaBuilder {
        private String size;
        private boolean cheese;
        private boolean pepperoni;

        public PizzaBuilder addSize(String size) {
            this.size = size;
            return this;
        }

        public PizzaBuilder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder addPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        // Build the Pizza object
        public Pizza build() {
            return new Pizza(this);
        }
    }

}