package com.practic.methodreference;

import java.util.function.Consumer;
import java.util.function.Function;

public class Test2 {

    public static void main(String[] args) {

        Function<Object,Integer> calculateHash = Object::hashCode;
        int hash = calculateHash.apply(new Test2());
       // System.out.println(hash);


        Consumer<Object> calculateHashCode = Object::hashCode;
        calculateHash.apply(new Test2());

        Consumer<String> printLogic = System.out::println;
        //printLogic.accept("Tauseef");

        IUpperCase iUpperCase = String::toUpperCase;
        String string = iUpperCase.convertToUpperCase("tauseef");
      //  System.out.println(string);




    }
}
