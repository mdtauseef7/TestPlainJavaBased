package com.practic.multithread.producerconsumer;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {
    public static void main(String[] args) {

        ThreadManager threadManager = new ThreadManager();
        ProducerThread producerThread = new ProducerThread("ProducerThread",threadManager);
        ConsumerThread consumerThread = new ConsumerThread("ConsumerThread",threadManager);

        producerThread.start();
        consumerThread.start();
    }
}


class ThreadManager{

    private final int queueSize =50;
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);
   Random random = new Random(100);
    public synchronized void  producerFunction(){
        if(queue.size() == queueSize){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Queue is full. Waiting for consumer to dequeue it.");
            notify();

        }
        Integer value = random.nextInt();
        System.out.println("Adding to the Queue: "+value);
        queue.add(value);
        notify();
    }

    public synchronized void consumerFunction(){
        if(queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Queue is empty. Waiting for consumer to dequeue it.");
            notify();
        }
        System.out.println("Queued elements are: "+queue.poll());
        notify();
    }
}


class ProducerThread extends Thread{
    ThreadManager threadManager;
    public ProducerThread(String threadName,ThreadManager threadManager){
        super(threadName);
        this.threadManager =threadManager;
    }

    public void run() {
        while(true) {
            threadManager.producerFunction();
        }
    }
}


class ConsumerThread extends Thread{ ThreadManager threadManager;
    public ConsumerThread(String threadName,ThreadManager threadManager){
        super(threadName);
        this.threadManager =threadManager;
    }

    public void run() {
        while(true) {
            threadManager.consumerFunction();
        }
    }
}

