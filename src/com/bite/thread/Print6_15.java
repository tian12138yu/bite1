package com.bite.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/15 18:53
 */

public class Print6_15 {

    static class t extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("干活！");
                try {
                    currentThread().sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new t();
        t.start();

        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        System.out.println("通知停止。。");
        t.interrupt();
//        print();

    }

    private static void print() {
        Thread thread = Thread.currentThread();
        System.out.println("线程优先级："+thread.getPriority());
        System.out.println("线程状态："+thread.getState());
        System.out.println("线程是否存活："+thread.isAlive());
        System.out.println("线程名称："+thread.getName());
        System.out.println("线程所属组："+thread.getThreadGroup());
        System.out.println("线程ID："+thread.getId());

    }


}
