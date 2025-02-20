package com.practic.common;

import java.io.*;

public class FibonacciExample {
    public static void main(String[] args) throws IOException {
        System.out.println("How many fibonacci number you want to print: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println("Here is the fibonacci series: ");
        for(int i=0;i<num;i++){
            System.out.println(fibonacci(i));
        }
    }

    static long fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
