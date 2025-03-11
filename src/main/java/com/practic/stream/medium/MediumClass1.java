package com.practic.stream.medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MediumClass1 {
    public static void main(String[] args) {

        String input = "swiss";

        String aNull = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse("null");

        //System.out.println(aNull);

        List<String> names = Arrays.asList("java", "stream", "api");

        List<String> collect = names.stream().map(String::toUpperCase).collect(Collectors.toUnmodifiableList());
        //System.out.println(collect);

        List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");

        Map<Integer, List<String>> collect1 = words.stream().collect(Collectors.groupingBy(String::length)); //, Collectors.mapping(Function.identity(), Collectors.toList())));
        //System.out.println(collect1);


        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> collect2 = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());

        //System.out.println(collect2);

        List<String> words1 = Arrays.asList("Stream", "API", "is", "powerful");

        String collect3 = words1.stream().collect(Collectors.joining(" "));
        //System.out.println(collect3);

        List<String> words3 = Arrays.asList("Java", "Stream", "API", "Development");

        Optional<String> max = words3.stream().max(Comparator.comparingInt(String::length));

        //System.out.println(max.get());

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        OptionalDouble average = numbers.stream().mapToDouble(Integer::valueOf).average();
        //System.out.println(average.getAsDouble());

        List<String> words4 = Arrays.asList("Java", "Stream", "API");
        Map<String, Integer> collect4 = words4.stream().collect(Collectors.toMap(Function.identity(), String::length));

        //System.out.println(collect4);

        String input8 = "success";

        Optional<Map.Entry<String, Long>> max1 = Arrays.stream(input8.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());

       // System.out.println(max1.get().getKey());

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> collect5 = list1.stream().filter(list2::contains).collect(Collectors.toList());
        //System.out.println(collect5);


        List<String> words10 = Arrays.asList("radar", "level", "java", "stream","avaj");

        Map<Boolean, List<String>> collect6 = words10.stream().collect(Collectors.partitioningBy(s -> new StringBuilder(s).reverse().equals(s)));
        //System.out.println(collect6.get(Boolean.TRUE));

        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 88),
                new Student("Dave", 78),
                new Student("Eve", 91)
        );

        List<Student> collect7 = students.stream().sorted(Comparator.comparing(Student::getScore, Comparator.reverseOrder())).limit(3).collect(Collectors.toUnmodifiableList());

        //System.out.println(collect7);

        List<String> words11 = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");

        Map<Character, List<String>> collect8 = words11.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        //System.out.println(collect8);

        List<Integer> numbers4 = Arrays.asList(4, 5, 6, 5, 4, 3);

        List<Integer> collect9 = numbers4.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey).collect(Collectors.toList());

        //System.out.println(collect9);


    }

}

class Student {
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    String name;
    int score;
    Student(String name, int score) { this.name = name; this.score = score; }
}
