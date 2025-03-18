package com.practic.stream;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();
        list.add("jayram");
        list.add("Vaibhav");
        list.add("Neeraj");
        list.add("Abhijeet");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            String next = iterator.next();
            if(next == "Vaibhav")
                list.remove(next);
        }

        System.out.println(list);
    }



}
