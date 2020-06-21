package com.bite.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author tjy
 * @Date 2020/6/21 17:17
 */

public class MyBlockingQueueMain {

    static MyBlockingQueue mb = new MyBlockingQueue();
    static class t2 extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    mb.push(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产 "+i);
            }

        }
    }

    static class t1 extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    mb.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费 "+i);
            }

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new t1().start();
        }
        for (int i = 0; i < 5; i++) {
            new t2().start();
        }
        new ArrayBlockingQueue<Integer>(10);

    }

}
