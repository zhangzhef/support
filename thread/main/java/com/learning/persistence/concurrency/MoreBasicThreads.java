package com.learning.persistence.concurrency;

/**
 * thread 3
 * Created by zzf on 17/5/8.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i= 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff!");
    }
}
