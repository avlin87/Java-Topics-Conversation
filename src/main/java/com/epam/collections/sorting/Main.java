package com.epam.collections.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<String> single1 = new ArrayList<>(Arrays.asList("Single1", "And", "Second", "Thrd"));
        single1.sort(String::compareTo);
        log.info(single1.toString());

        single1.sort(Comparator.reverseOrder());
        log.info(single1.toString());

        single1.sort(Comparator.comparingInt(String::length));
        log.info(single1.toString());

        Map<String, Integer> map = new TreeMap<>(Comparator.comparingInt(String::length));
        map.put("Second", 100);
        map.put("Single1", 100);
        map.put("Thrd", 100);
        map.put("And", 100);
        map.forEach((k, v) -> log.info("{} : {}", k, v));

        log.info(Collections.max(single1), Comparator.comparingInt(String::length));
    }
}
