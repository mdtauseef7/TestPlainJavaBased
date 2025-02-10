package com.practic.methodreference;

import java.util.function.BiFunction;

public class Test3 {

    public static void main(String[] args) {
        String str1= "Hello";
        String str2= "world";
        String result = str1.concat(str2);
       // System.out.println(result);


        BiFunction<String,String,String> biFunction = String::concat;
        String str4 = biFunction.apply("Selenuim ","Express");
        System.out.println(str4);






    }



}
