package com.java8.streams.dp;

import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String input = "programming";

        Map<Character, Long> duplicates = input.chars() // Convert the string to an IntStream
                .mapToObj(c -> (char) c) // Convert each int to a Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Count occurrences

        // Filter characters with frequency greater than 1 and print them
        duplicates.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry ->
                        System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue())
                );
    }
    /*sss
    * Explanation:
input.chars(): Converts the string into an IntStream of character codes.
mapToObj(c -> (char) c): Converts the character codes back to Character objects.
Collectors.groupingBy(...): Groups characters and counts their occurrences.
filter(entry -> entry.getValue() > 1): Filters entries with a count greater than 1.
forEach(...): Prints the duplicate characters and their counts.*/
}
