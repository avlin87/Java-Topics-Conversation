package com.epam.spring.start.domain.stat;

import com.epam.spring.start.domain.iml.Cat;

public class LessonExample {
    public static int count;
    public static final String MY_NAME = "ALEX";
    public static final int YEAR_OF_BIRTH = 1987;

    public final Cat myCat = new Cat();

    public LessonExample() {
        count++;
    }

    public static void main(String[] args) {
        new LessonExample();
        new LessonExample();
        System.out.println(count);
    }
}