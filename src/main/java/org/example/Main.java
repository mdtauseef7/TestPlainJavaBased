package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,113,56,44);

        List<List<Integer>> integerList1 = Arrays.asList(integerList);

        List<List<List<Integer>>> list = Arrays.asList(integerList1);


        list.stream().flatMap(Collection::stream).flatMap(Collection::stream).toList().forEach(System.out::println);


    }
}