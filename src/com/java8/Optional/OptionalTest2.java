package com.java8.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest2 {
    public static void main(String[] args) {
        /*Transforming Values
        You can transform the value inside an Optional using map() or flatMap().*/

        Optional<String> opt = Optional.of("Java");
        Optional<Integer> length = opt.map(String::length);
        length.ifPresent(System.out::println); // Output: 4

        Optional<String> opt1 = Optional.of("Java");
        Optional<String> upper = opt1.flatMap(value -> Optional.of(value.toUpperCase()));
        upper.ifPresent(System.out::println); // Output: JAVA

        //Filtering Values

        Optional<String> opt2 = Optional.of("Java");
        opt2.filter(value -> value.startsWith("J"))
                .ifPresent(System.out::println); // Output: Java


        String result = Optional.ofNullable(" Java Optional ")
                .map(String::trim)
                .filter(value -> value.length() > 5)
                .orElse("Default");
        System.out.println(result); // Output: Java Optional

        List<String> names = Arrays.asList("John", null, "Jane");
        List<String> result4 = names.stream()
                .map(Optional::ofNullable)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        System.out.println(result4); // Output: [John, Jane]

    }
}
