package com.learning.persistence.concurrency;

/**
 * thread2
 * Created by zzf on 17/5/8.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());//线程上 附着 任务
        t.start();
        System.out.println("Waiting for LiftOff!");

    }
}
