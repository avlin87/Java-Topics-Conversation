package com.epam.spring.start.domain.iml;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Kitten extends Cat{
    public void eat(String meal) {
        log.info("Cat is eating {}", meal);
    }
}
