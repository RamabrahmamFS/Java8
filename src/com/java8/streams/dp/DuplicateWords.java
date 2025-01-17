package com.java8.streams.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWords {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

       // System.out.println(wordCount);
        wordCount.entrySet().stream().filter(entry->entry.getValue()>1).forEach(entry->System.out.println(entry.getKey()+ " (Count: " + entry.getValue() + ")"));


    }
}
