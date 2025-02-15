package com.practic.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Genz {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,10,25);

        //myList.stream().filter(num -> num%2 == 0).forEach(System.out::println);

       // myList.stream().map(String::valueOf).filter(num -> num.startsWith("1")).forEach(System.out::println);

        Map<Integer, Long> collect = myList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       // System.out.println(collect);

        List<Integer> collect1 = myList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        //System.out.println(collect1);

        long count = myList.stream().count();
        // System.out.println(count);

        OptionalInt max = myList.stream().mapToInt(Integer::intValue).max();
       // System.out.println(max.getAsInt());

        String input = "Java articles are Awesome";

       //Stream.of(input).map(String::toCharArray)

        Optional<Character> first = input.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst();

       // System.out.println(first.get());

        Optional<Character> firstRep = input.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).findFirst();

       // System.out.println(firstRep.get());

       // myList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        String collect2 = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.joining(" "));

        //System.out.println(collect2);

        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        List<Integer> list = integerList.stream().map(num -> num * num * num)
                .filter(num -> num > 10)
                .toList();

        //System.out.println(list);

        int arr[] = { 99, 55, 203, 99, 4, 91 };

       // IntStream.of(arr).sorted().forEach(System.out::println);

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC", "CC");

        Map<String, Long> collect3 = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //System.out.println(collect3);

        List<String> list3 = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        //System.out.println(list3);

        String s = "string data to count each character";

        String trimed = s.replaceAll(" ","");

        Map<String, Long> collect4 = Arrays.stream(trimed.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //System.out.println(collect4);

        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,32,10,25);

        IntSummaryStatistics stats = numbers.stream() .mapToInt(Integer::intValue) .summaryStatistics();

        //System.out.println(stats);

        List<Integer> intList1 = Arrays.asList(24,5,5,4,3,1);


        List<List<Integer>> cilitiesList = Arrays.asList(intList1);

        //System.out.println(cilitiesList);

        int sum = cilitiesList.stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println(sum);


    }
}
