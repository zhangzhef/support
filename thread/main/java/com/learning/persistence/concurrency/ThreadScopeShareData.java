package com.learning.persistence.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ThreadScopeShareData {

    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();//模拟localThread

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {

            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println("A from " + Thread.currentThread().getName()
                            + " get data:" + data);
                    threadData.put(Thread.currentThread(), data);                }
            }).start();
            new A().get();
            new B().get();
        }
    }

    /**
     * Exception in thread "main" java.lang.NullPointerException
     at com.learning.persistence.concurrency.ThreadScopeShareData$A.get(ThreadScopeShareData.java:33)
     at com.learning.persistence.concurrency.ThreadScopeShareData.main(ThreadScopeShareData.java:26)
     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     A from Thread-0 get data:189553281
     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     at java.lang.reflect.Method.invoke(Method.java:498)
     at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
     */
    static class A {
        public void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName()
            + " get data:" + data);
        }
    }
    static class B {
        public void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data:" + data);
        }
    }
}
