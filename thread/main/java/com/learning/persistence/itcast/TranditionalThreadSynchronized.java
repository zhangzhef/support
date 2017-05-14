package com.learning.persistence.itcast;

/**
 * Created by zzf on 17/5/14.
 */
public class TranditionalThreadSynchronized {

    public static void main(String[] args) {
//        final Outputer outputer = new Outputer();//内部类创建对象问题，需要一个外部类
        new TranditionalThreadSynchronized().init();
    }


    private void init() {
        //同个对象
        final Outputer outputer = new Outputer();//内部类创建对象问题，需要一个外部类
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {

                    }
                    outputer.output("zhangxiaoxiang");
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {

                    }
                    outputer.output("lihuoming");
                }
            }
        }).start();
    }

    /**
     * 加 static 类似一个外部类
     */
    static class Outputer {
        Object obj = new Object();
        public void output(String name) {
            int len = name.length();
            /**
             * 同步代码快
             */
            synchronized (this) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        /**
         * this
         * @param name
         */
        public synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        /**
         * 字节码
         * @param name
         */
        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}

