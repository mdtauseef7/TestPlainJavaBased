package com.practic.interviewquestion.wellsfargo;

//Write a java program to get min subArray which contains minimum and maximum ele.


public class SmallestSubArray {
    public static void main(String[] args) {{
        int[] arr = {3, 5, 8, 1, 10, 13, 2, 15,1, 20};
        int minIndex = -1, maxIndex = -1, smallEle = Integer.MAX_VALUE, maxEle = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (smallEle > arr[i]) {
                smallEle = arr[i];
            }
            if (maxEle < arr[i]) {
                maxEle = arr[i];
            }
        }

        int minSubrray = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(smallEle == arr[i]){
                minIndex = i;
            }
            if(maxEle == arr[i]){
                maxIndex = i;
            }
            if(minIndex != -1 && maxIndex != -1){
                minSubrray = Math.min(minSubrray, Math.abs(maxIndex-minIndex));
            }
        }
        System.out.println(minSubrray);

    }



    }
}
