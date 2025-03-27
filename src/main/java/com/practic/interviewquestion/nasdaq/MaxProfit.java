package com.practic.interviewquestion.nasdaq;

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

        int minSofar=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0; i<arr.length;i++){
            if(minSofar> arr[i]){
                minSofar =arr[i];
            }
            maxProfit = Math.max(maxProfit, arr[i]-minSofar);
        }
        System.out.println(maxProfit);
    }
}
