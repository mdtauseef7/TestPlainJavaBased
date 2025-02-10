package com.practic.designpattern.singleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SingleTon {

    public static void main(String[] args)
    {
        Long startTime = System.currentTimeMillis();
        int n = 10; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object  = new MultithreadingDemo();
            object.start();
        }

        System.out.println("Total time taken to execute this process is: "+ (System.currentTimeMillis()-startTime));
    }


}
class MultithreadingDemo extends Thread {
    private static Set<SingleTonOb> duplicateObj = new HashSet<>();


    public void run()
    {
        try {
           System.out.println("Thread " + Thread.currentThread().getId() + " has created singleton Object: "+SingleTonOb.getInstance());
            duplicateObj.add(SingleTonOb.getInstance());
            if(duplicateObj.size() >1){
                System.out.println("Duplicate found !!!");
            }

        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }

        HashMap map =new HashMap<>(16);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(4);
    }
}

class SingleTonOb{
    private static SingleTonOb instance = new SingleTonOb();
    private SingleTonOb(){
        System.out.println("--Default Constructor called() ---");
    }

      public static  SingleTonOb getInstance(){
            return instance;
    }
}
