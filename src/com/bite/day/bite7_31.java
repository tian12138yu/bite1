package com.bite.day;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tjy
 * @Date 2020/7/31 12:00
 */

public class bite7_31 {

    static class a{
        Object o1 = new Object();
        Object o2 = new Object();

        public void x() throws InterruptedException {
            synchronized (o1){
                Thread.sleep(3000);
                synchronized (o2){
                    System.out.println(" dsad a");
                }
            }
        }

        public void y() throws InterruptedException {
            synchronized (o2){
                Thread.sleep(3000);
                synchronized (o1){
                    System.out.println(" dsad a");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        a a = new a();
        new Thread(() -> {
            try {
                a.x();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                a.y();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new ReentrantLock();
    }
}
