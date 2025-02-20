package com.practic.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<5; i++) {
            int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task Executing..."+taskId+" by ThreadName: "+Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}









