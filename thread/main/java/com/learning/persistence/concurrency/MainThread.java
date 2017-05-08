package com.learning.persistence.concurrency;

/**
 * Created by zzf on 17/5/8.
 */
public class MainThread {

    public static void main(String[] args) {
        //任务直接调用
        LiftOff luanch = new LiftOff();
        luanch.run();//
    }
}
