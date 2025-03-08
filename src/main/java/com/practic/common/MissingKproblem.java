package com.practic.common;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;

public class MissingKproblem {
    public static void main(String[] args) {
        int[] arr ={10,13,12,8};
        //missingKFun(arr,4);
        int[] arr1 ={1,2,3};
      // System.out.println(xorSum(arr1));

        System.out.println(finalStatus(null));
    }
   static void missingKFun(int[] arr,int size){
       TreeSet<Integer> treeSet = new TreeSet<>();
       for(int i=0 ;i<arr.length;i++){
           treeSet.add(arr[i]);
       }
       int lowest = treeSet.first();
       int highest = treeSet.last();
       //System.out.println(lowest+"^^^^^^^"+highest);
       int count =0;
       for(int j=lowest+1;j<=highest;j++){
           if(!treeSet.contains(j)){
               count++;
           }
       }
       System.out.println(count);
    }


    static int xorSum(int[] arr){

        int[] newArray = new int[arr.length];

        for(int i=0; i<arr.length;i++){
            if(i==0){
                newArray[i] = Math.abs(arr[i+1]-arr[arr.length-1]);
            }else if(i == arr.length-1){
                newArray[i] = Math.abs(arr[0]-arr[arr.length-2]);
            }else{
                newArray[i] = Math.abs(arr[i-1]-arr[i+1]);
            }

        }

        int sum =0;

        for(int j=0; j <newArray.length; j++){
            sum = sum + newArray[j]^j;
        }

        return sum;
    }


    static String finalStatus(String str){
            if(str ==null){
                return null;
            }
        String[] status = str.split(";");

        return status[status.length-1];

    }



}




