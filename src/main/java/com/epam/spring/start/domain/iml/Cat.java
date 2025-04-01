package com.epam.spring.start.domain.iml;

import com.epam.spring.start.domain.Animal;
import com.epam.spring.start.domain.Mammals;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Mammals implements Animal {


    @Override
    public void run() {
        log.info("Cat is running");
    }

    @Override
    public void sleep() {
        log.info("Cat is sleeping");
    }

    @Override
    public void eat() {
        log.info("Cat is eating");
    }


    public void eat(int timesADay) {
        log.info("Cat eats {} times a day", timesADay);
    }

    public void purr() {
        log.info("Cat is purring");
    }

    @Override
    public void drinkMilk() {
        log.info("cat is drinking milk");
    }

    @Override
    public void selfHeating() {

    }

    @Override
    public void hide(){
        log.info("Cat is hiding");
    }
}
