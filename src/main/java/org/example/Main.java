package org.example;

public class Main {
    public static void main(String[] args){


   Derived derived = new Derived();

   derived.show();



    }
}

abstract class Base{

     void display()
    {
        System.out.println("displays");
    }

    void show(){
        display();
    }

}

class Derived extends Base{

    void display(){
        System.out.println("Base displays");

    }

}