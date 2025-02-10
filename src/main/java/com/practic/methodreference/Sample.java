package com.practic.methodreference;

public class Sample {

    public static void main(String[] args) {

        IAddition iAddition = Sample::doAddition;
       int sum=  iAddition.sum(new Sample(),10,20);
        System.out.println(sum);

    }

     int doAddition(int a, int b){
        return a+b;
    }
}
