package com.learning.persistence.itcast;

/**
 * 共享数据，放在同一个类里！！！
 * Created by zzf on 17/5/14.
 */
public class TraitionalThreadCommunication {


    public static void main(String[] args) {
        final Bisiness biz = new Bisiness();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                        biz.sub(i);
                }
            }
        }).start();

            for (int i = 0; i < 50; i++) {
                    biz.main(i);
            }
    }

}
class Bisiness {

    private boolean bShoutSub = true;

    public synchronized void sub(int i) {
        while (!bShoutSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            for (int j = 0; j < 10; j++) {

                System.out.println("sub thread of " + i + ", loop of " + j);
            }
        bShoutSub = false;
        this.notify();

    }

    public synchronized void main(int i) {
        while (bShoutSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            for (int j = 0; j < 100; j++) {

                System.out.println("main thread of " + i + ", loop of " + j);
            }
        bShoutSub = true;
        this.notify();
    }

}

