package com.practic.pattern;

public class Test {

    public static void main(String[] args) {
        printSequence(5);
    }
    public static void printSequence(int noOfRows){
        for(int i=0;i <=noOfRows; i++){
            int val  = 65 + noOfRows-i;
            for (int j = 0; j <=i;j++){
                System.out.print(Character.toString((char)val)+" ");
                val++;
            }
            System.out.println();
        }
    }

    public static void printSequence1(int noOfRows){
        int notToPrint = noOfRows/2;
        for(int i=0;i <=noOfRows; i++){
            for (int j = 0; j <= noOfRows; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}
