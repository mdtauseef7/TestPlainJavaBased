package com.practic.multithread.counter;

import org.example.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet();  // Atomic operation
    }
    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicCounter counter = new AtomicCounter();
        long startTime = System.currentTimeMillis();
        // Submit 1000 increment tasks
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { } // wait for all tasks to finish
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Final count (with AtomicInteger): " + counter.getCount()+" in time: "+ timeTaken);
    }
}
