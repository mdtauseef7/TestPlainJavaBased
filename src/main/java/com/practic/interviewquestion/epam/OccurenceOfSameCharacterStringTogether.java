package com.practic.interviewquestion.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OccurenceOfSameCharacterStringTogether {
    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        /*   output:
            [epam, pame, aepm] contains same character
            [java, ajav] contains same character
           [abcd, dcba] contains same character*/

        // Stream.of(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Map<String, Double> mapWithAscii = new HashMap<>();
        Arrays.stream(arr).forEach(a -> {
            double asci = Arrays.stream(a.split("")).map(cha -> (int) cha.toCharArray()[0]).reduce(0, (s1, s2) -> s1 + s2).doubleValue();
            mapWithAscii.put(a, asci);
        });
        Map<Double, List<String>> groupedBySameAsCIIValue = mapWithAscii.entrySet().stream().
                collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        System.out.println("::::Answer::::::\n" + groupedBySameAsCIIValue.values());
    }
}
