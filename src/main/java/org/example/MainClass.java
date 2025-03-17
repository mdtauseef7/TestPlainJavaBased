package org.example;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] % 2 == 0) ? arr[i] : 0;
        }
        System.out.println(sum);

    }
}

