package org.example;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        int [] arr = {63,46,12,95,22,44,38,27,30,66};



        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(2).findFirst().ifPresent(System.out::println);

        String s1 ="Hello";
        String s2 ="World";
        String s3 = s1+s2;
        String s4 ="HelloWorld";

        System.out.println(s3.hashCode() == s4.hashCode());


    }
}

