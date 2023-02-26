package com.dy.demo.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DelayQueueDemo {

    static DelayQueue<MyDelay> queue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {

        queue.add(new MyDelay(5000, "5s 延时队列，任务执行"));
        queue.add(new MyDelay(3000, "3s 延时队列，任务执行"));
        queue.add(new MyDelay(1000, "1s 延时队列，任务执行"));

        while (!queue.isEmpty()){
            MyDelay take = queue.take();
            System.out.println(take);
        }
    }

}

class MyDelay<T> implements Delayed{

    long delayTime; //延时时间
    long expire; //过期时间
    T data;

    public MyDelay(long delayTime, T data) {
        this.delayTime = delayTime;
        this.expire = System.currentTimeMillis() + delayTime;
        this.data = data;
    }

    /**
     * 剩余时间 = 到期时间 - 当前时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 优先级规则 两个任务比较 , 时间短的优先执行
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        long f = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
        return (int)f;
    }

    @Override
    public String toString() {
        return "delayTime=" + delayTime +
                ", expire=" + expire +
                ", data=" + data;
    }

}

