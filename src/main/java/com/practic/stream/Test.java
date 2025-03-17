package com.practic.stream;

public class Test {
    static void method(Object obj) {
        System.out.println("Object method");
    }

    static void method(String str) {
        System.out.println("String method");
    }

    public static void main(String[] args) {
        method(null); // Which method gets called?
    }



}
