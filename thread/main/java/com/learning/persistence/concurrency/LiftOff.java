package com.learning.persistence.concurrency;

/**
 * Created by zzf on 17/5/8.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;//default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.print(Thread.currentThread().getName() + "::" + status());
            Thread.yield();// 对线程调度器的一种建议
        }
     }
}
