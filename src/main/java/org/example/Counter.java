package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    /*private   int  count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { }

        System.out.println(counter.getCount());
    }*/

    private AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet();  // Atomic operation
    }
    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        // Submit 1000 increment tasks
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) { } // wait for all tasks to finish
        System.out.println("Final count (with AtomicInteger): " + counter.getCount());
    }
}
