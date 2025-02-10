package com.practic.multithread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Friend extends Thread{

    private String friendsName;
    private CyclicBarrier barrier;

    public Friend(String friendsName, CyclicBarrier barrier){
        this.friendsName = friendsName;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(friendsName+" has started...");
        getReadyAndBeAtMeetingPoint();
        System.out.println(friendsName +" has reached.. and waiting other: "+ (int)(barrier.getParties()- barrier.getNumberWaiting())+" friends");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(friendsName+": is continuing with the trip");
    }

    private void getReadyAndBeAtMeetingPoint() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(5000,15000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
