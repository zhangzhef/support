package com.learning.persistence.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** thread 6
 * Created by zzf on 17/5/8.
 */
public class SingleThreadPool {

    public static void main(String[] args) {
        /**
         *  提交顺序 执行
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
