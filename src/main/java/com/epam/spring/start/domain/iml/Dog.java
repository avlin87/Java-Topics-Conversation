package com.epam.spring.start.domain.iml;

import com.epam.spring.start.domain.Animal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog implements Animal {

    @Override
    public void run() {
        log.info("Dog run");
    }

//    @Override
//    public void sleep() {
//        log.info("Dog sleep");
//    }

    @Override
    public void eat() {
        log.info("Dog eat");
    }

    public void bark() {
        log.info("Dog bark");
    }
}
