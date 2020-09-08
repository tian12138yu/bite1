package com.bite.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author tjy
 * @Date 2020/9/8 14:11
 */

public class BlockingQueueDemo {

    final int x = 50;

    public static void main1(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        /**
         * 1.报错
         * 2.返回bool
         * 3.阻塞
         * 4.阻塞时间
         */
        queue.add(2);
        queue.remove();
        queue.offer(5);
        queue.poll();
        try {
            queue.put(6);
            queue.take();
            queue.offer(1,3,TimeUnit.SECONDS);
            queue.poll(3,TimeUnit.SECONDS);
        }catch (Exception e){

        }

        Runnable r = new Runnable(){

            @Override
            public void run() {

            }
        };

        Runnable r1 = ()->{
            System.out.println("111");
        };

        new Thread(r1).start();


    }




}
