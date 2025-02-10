package com.practic.methodreference;

public class MethodRefence {

    public static void main(String[] args) {
        ISum iSum = MethodRefence::addition;
        Integer val= iSum.sum(1,2);
        System.out.println(val);
    }


    public static int addition(int val1, int val2){
        return val1 + val2;
    }
}
