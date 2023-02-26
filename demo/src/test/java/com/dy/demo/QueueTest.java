package com.dy.demo;

import java.util.concurrent.ConcurrentSkipListMap;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {

        Queue queue = new Queue(5);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                System.out.println(queue.take());
            }
        }).start();

    }
}
