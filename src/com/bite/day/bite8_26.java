package com.bite.day;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author tjy
 * @Date 2020/8/26 10:58
 */

public class bite8_26 {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a){
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("加锁a+b");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b){
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("加锁a+b");
                }
            }
        }).start();

    }



}
