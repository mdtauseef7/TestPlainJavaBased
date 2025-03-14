package com.practic.multithread.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter {
    private   int  count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(counter.getCount()+"  time taken: "+timeTaken);
    }
}
