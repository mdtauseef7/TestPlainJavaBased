package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //Base derived = new Derived();
        //derived.show();

        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<>(1000000);
// Populate list...
        int sum = 0;
        for (Integer value : list) {
            sum += value; // Iterator overhead
        }

        /*List<Integer> list = new ArrayList<>(1000000);
        // Populate list...
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i); // Direct access
        }*/
        //950900
        //721300

        long timeTaken = System.nanoTime()-startTime;

        System.out.println("Time taken: "+ timeTaken);


    }
}

 class Base{

     void display()
    {
        System.out.println("Base displays");
    }

    void show(){
        display();
    }

}

class Derived extends Base{

    void display(){
        System.out.println("Derived displays");

    }

}