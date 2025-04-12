package com.epam.patterns.creational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Create new objects by cloning an existing object, rather than instantiating a class.
 */
public class Prototype {

    public static void main(String[] args) {
        // Create a Circle prototype
        Circle circle = new Circle("Red", 10);
        circle.draw();

        // Clone the Circle
        Circle clonedCircle = (Circle) circle.clone();
        clonedCircle.setColor("Blue");
        clonedCircle.setRadius(15);
        clonedCircle.draw();

        // Create a Rectangle prototype
        Rectangle rectangle = new Rectangle("Green", 20, 30);
        rectangle.draw();

        // Clone the Rectangle
        Rectangle clonedRectangle = (Rectangle) rectangle.clone();
        clonedRectangle.setColor("Yellow");
        clonedRectangle.setWidth(25);
        clonedRectangle.setHeight(35);
        clonedRectangle.draw();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static abstract class Shape implements Cloneable {
        private String color;

        // Abstract method to display the shape
        public abstract void draw();

        // Clone method to create copies
        @Override
        public Shape clone() {
            try {
                return (Shape) super.clone();  // Returns a shallow copy
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Clone not supported!", e);
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    private static class Circle extends Shape {
        private int radius;

        public Circle(String color, int radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a " + getColor() + " Circle with radius: " + radius);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    private static class Rectangle extends Shape {
        private int width;
        private int height;

        public Rectangle(String color, int width, int height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw() {
            System.out.println("Drawing a " + getColor() + " Rectangle with width: " + width + ", height: " + height);
        }
    }

}
