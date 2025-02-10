package com.practic.interfaceexample;


interface A{
    default void display(){
        System.out.println("A");
    }
}


interface B{
    default void display(){
        System.out.println("B");
    }
}

public class Test implements A,B{
    @Override
    public void display() {
        B.super.display();
    }
}


