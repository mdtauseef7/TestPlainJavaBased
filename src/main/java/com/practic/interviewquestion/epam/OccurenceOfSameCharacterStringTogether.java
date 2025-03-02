package com.practic.interviewquestion.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OccurenceOfSameCharacterStringTogether {
    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        /*   output:
            [epam, pame, aepm] contains same character
            [java, ajav] contains same character
           [abcd, dcba] contains same character*/

        // Stream.of(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<String , Integer> wordSum = new HashMap<>();
        Arrays.stream(arr).forEach(word ->{
            Integer asciiSum = Stream.of(word.split("")).map(s -> (int) s.toCharArray()[0]).reduce(0, (integer, integer2) -> integer + integer2);
            wordSum.put(word,asciiSum);
        });
        wordSum.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey,  Collectors.toList())))
                .entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
    }
}
