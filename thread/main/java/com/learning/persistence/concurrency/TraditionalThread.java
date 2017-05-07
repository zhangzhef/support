package com.learning.persistence.concurrency;

/**
 * Created by zhang on 2017/5/7 0007.
 */
public class TraditionalThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){// 子类
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread1:" + Thread.currentThread().getName());
                    System.out.println(":" + this.getName());//this 该对象　当前线程　　　
                }
            }
        };

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
//            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread2:" + Thread.currentThread().getName());
                    //                    System.out.println(":" + this.getName());//this 任务对象　　　　
                }
            }
        }) {};

        thread1.start();

        new Thread(new Runnable() {
//            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread3:" + Thread.currentThread().getName());
                }
            }
        }){
            public void run() {//运行子类方法
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread4:" + Thread.currentThread().getName());
                }
            }
        }.start();

    }
}
