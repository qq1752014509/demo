package com.dy.demo;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列 测试类
 */
public class Queue<T> {

    private LinkedList<T> queue = new LinkedList();
    private int queueMaxCount;

    public Queue(int queueMaxCount) {
        this.queueMaxCount = queueMaxCount;
    }

    //生产消息
    public synchronized void put(T t) throws InterruptedException {
        while (queue.size() == queueMaxCount){
            System.out.println("队列已满，请等待。。。。");
            this.wait();
        }
        queue.add(t);
        return;
    }

    //消费消息
    public synchronized T take() {
        while (!queue.isEmpty()){
            this.notifyAll();
            System.out.println("消费消息，通知。。。。");
            return queue.pollFirst();
        }
        return null;

    }

}
