package com.epam.spring.start.domain;

import com.epam.spring.start.domain.iml.Cat;
import com.epam.spring.start.domain.iml.Dog;
import com.epam.spring.start.domain.iml.Kitten;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AnimalService {

    public static void main(String[] args) {
        AnimalService service = new AnimalService();

        Cat cat = new Cat();
        cat.setAge(4);
        
        Mammals kitten = new Kitten();
        Dog dog = new Dog();

        service.drink(List.of(cat, kitten));

        dog.eat(dog);
    }

    public void drink(List<Mammals> mammals) {
        mammals.forEach(mammal -> {
            mammal.drinkMilk();
            mammal.hide();
        });
    }

    public void makeAnimalRace(List<Animal> animals) {
        animals.stream().peek(animal -> {
            if (animal instanceof Dog gog1) {
                gog1.bark();
            }
            if (animal instanceof Cat) {
                ((Cat) animal).purr();
            }
        }).forEach(Animal::run);
    }
}
