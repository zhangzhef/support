package com.learning.persistence.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thread 5
 * Created by zzf on 17/5/8.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        /**
         * ExecutorService 具有生命周期对 Executor
         * CachedThreadPool 为每个任务创建一个线程， 《在它回收旧线程时停止创建新线程》？
         * FixedThreadPool 使用了有限对线程集来执行
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();//防止新任务被提交给这个Executor
        Long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("用时：" + (end - start));
    }
}
