package com.epam.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class CollectionsExample {

    public static void main(String[] args) {
        Map<Fruit, Integer> fruits = examples();

        for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            log.info(entry.getKey() + " " + entry.getValue());
        }

        fruits.forEach((key, value) -> log.info("{} {}", key, value));

        Map<Fruit, Integer> collected = fruits.entrySet().stream()
                .filter(entry -> entry.getValue() > 10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));

        Map<String, Integer> collect = Stream.of("Apple / 10", "Banana / 20", "Watermelon / 70", "Cucumber / 90", "Apple / 40")
                .map(string -> Arrays.stream(string.split("/"))
                        .map(String::trim)
                        .toList())
                .collect(Collectors.toMap(
                        pair -> pair.get(0),
                        pair -> Integer.parseInt(pair.get(1)),
                        (existing, newValue) -> existing,
                        TreeMap::new
                ));
    }

    private static List<Integer> extracted(int max) {
        return Stream.of(32, 42, 53).filter(x -> x > max).toList();
    }

    private static Map<Fruit, Integer> examples() {
        Apple greenApple = new Apple("Green", 12);
        Apple redApple = new Apple("Red", 13);
        Apple red = new Apple("Red", 13);
        Banana yellow = new Banana("Yellow", 21);
        Banana yellow1 = new Banana("Yellow", 21);

        Set<Fruit> set = new HashSet<>();
        set.add(greenApple);
        set.add(redApple);
        set.add(red);
        set.add(yellow1);
        set.add(yellow);

        Map<Fruit, Integer> mapOfFruits = new HashMap<>();
        mapOfFruits.put(greenApple, 100);
        mapOfFruits.put(redApple, 200);
        mapOfFruits.put(red, 250);
        mapOfFruits.put(yellow, 300);
        mapOfFruits.put(yellow1, 350);
        return mapOfFruits;
    }
}
