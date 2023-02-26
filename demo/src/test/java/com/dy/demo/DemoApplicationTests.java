package com.dy.demo;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ticketThread implements Callable {

    private int ticket;
    private Object obj = new Object();

    public ticketThread(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public Integer call() throws Exception {
        int resultInt = 0;
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket-- + "张票");
                    resultInt++;
                } else {
                    return resultInt;
                }
            }
        }
    }
}

class DemoApplicationTests {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.equals(o2));
        System.out.println(o1==o2);
        int ticket = 100;
        ticketThread ticketThread = new ticketThread(ticket);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future f1 = pool.submit(ticketThread);
        Future f2 = pool.submit(ticketThread);
        Future f3 = pool.submit(ticketThread);
        try {
            Integer i1 = (Integer) f1.get();
            Integer i2 = (Integer) f2.get();
            Integer i3 = (Integer) f3.get();
            System.out.println("i1=======>>>" + i1);
            System.out.println("i2=======>>>" + i2);
            System.out.println("i3=======>>>" + i3);
            System.out.println("sum=======>>>" + (i1.intValue()+i2.intValue()+i3.intValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
        System.out.println("执行结束");


    }


}
