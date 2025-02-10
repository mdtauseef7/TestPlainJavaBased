package com.practic.multithread.cyclicbarrier;

import com.practic.multithread.cyclicbarrier.Friend;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final int noOfFriends = 5;
    private static final CyclicBarrier barrier = new CyclicBarrier(noOfFriends);

    public static void main(String[] args) {
        for (int i= 0; i< noOfFriends;i++ ){
            Friend friends = new Friend("Friend: "+i, barrier);
            friends.start();
        }
    }
}
