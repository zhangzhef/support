package com.learning.persistence.concurrency;

/**
 * 共享资源 抽象类
 * Created by zhang on 2017/5/10 0010.
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {return canceled;}

}
