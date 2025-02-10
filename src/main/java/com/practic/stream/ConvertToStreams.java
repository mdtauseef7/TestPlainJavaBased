package com.practic.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertToStreams {
    public static void main(String[] args) {

        int[] premitiveArrays = {4,4,3,3,34,43,432,4};

        Integer[] objectArrays = {464,456,464,56,65,23};

        IntStream premitiveArrays1 = IntStream.of(premitiveArrays);
        //premitiveArrays1.forEach(System.out::print);
        System.out.println();

        Stream<Integer> stream = Arrays.stream(objectArrays);
        //stream.forEach(System.out::print);








    }
}
