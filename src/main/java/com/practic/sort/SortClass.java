package com.practic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class SortClass {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(4,5,7,2,3,2,1,9,10);

        Consumer<List<Integer>> arraySort = Collections::sort;
        arraySort.accept(integerList);

       System.out.println(integerList);



    }
}
