package com.java8.Optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        //Step 1: Create an Optional Object
        Optional<String> emptyOpt = Optional.empty();
        System.out.println(emptyOpt.isPresent());

        Optional<String> optWithValue = Optional.of("Hello");
        System.out.println(optWithValue.isPresent());

        Optional<String> optNullable = Optional.ofNullable(null);
        System.out.println(optNullable.isPresent());

        //Step 2: Check the Presence of a Value
        Optional<String> opt = Optional.of("Java");
        if (opt.isPresent()) {
            System.out.println("Value is present: " + opt.get());
        }

        //This method accepts a lambda expression:
        Optional<String> opt2 = Optional.of("Java Optional");
        opt2.ifPresent(value -> System.out.println("Value: " + value));

        //Step 3: Provide a Default Value
        //This method returns the value if present, otherwise returns other.
        String value = (String) Optional.ofNullable(null).orElse("Default Value");
        System.out.println(value); // Output: Default Value

        //orElseGet() accepts a supplier for lazy evaluation:
        //This method returns the value if present, otherwise it invokes the supplied function and returns the result of that function.
        String value3 = (String) Optional.ofNullable(null).orElseGet(() -> "Lazy Default");
        System.out.println(value3); // Output: Lazy Default

        String value4 = (String) Optional.ofNullable(null).orElseThrow(() -> new IllegalArgumentException("Value not present"));

    }
}
