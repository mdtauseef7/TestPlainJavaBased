package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        String str ="Fear leads to anger; anger leads to hatred; hatred leads to conflict; conflict leads to suffering.";

        // Splitting to find the word
        String arr[]=str.split(" ");

        int count =1;
        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {

            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }

        }
        // Loop to iterate over the
        // elements of the map
        for(Map.Entry<String,Integer> entry:
                hm.entrySet())
        {
            System.out.println(entry.getKey()+
                    " - "+entry.getValue());
        }


        String str1 = null;
        str1.substring(0,1);



    }
}

