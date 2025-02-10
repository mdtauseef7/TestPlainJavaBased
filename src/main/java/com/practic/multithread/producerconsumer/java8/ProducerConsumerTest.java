package com.practic.multithread.producerconsumer.java8;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProducerConsumerManager threadManager = new ProducerConsumerManager();
        new Thread(( ) -> {
            while(true) {
                threadManager.producerFunction();
            }
        }).start();

        new Thread(() ->{
            while (true) {
                threadManager.consumerFunction();
            }

        }).start();
    }
}
class ProducerConsumerManager {
    private final int queueSize =50;
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);
    Random random = new Random(100);
    public synchronized void  producerFunction(){
        if(queue.size() == queueSize){
            System.out.println("Queue is full. Waiting for consumer to dequeue it.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();
        }
        Integer value = random.nextInt();
        System.out.println("Adding to the Queue: "+value);
        queue.add(value);
        notify();
    }

    public synchronized void consumerFunction(){
        if(queue.isEmpty()){
            System.out.println("Queue is empty. Waiting for producer to add.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();
        }
        System.out.println("Dequeued elements are: "+queue.poll());
        notify();
    }
}

