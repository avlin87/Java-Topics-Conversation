package com.epam.collections;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Apple implements Fruit {
    private String color;
    private int weight;

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Apple apple = (Apple) o;
//        return weight == apple.weight && Objects.equals(color, apple.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(color, weight);
//    }
}
