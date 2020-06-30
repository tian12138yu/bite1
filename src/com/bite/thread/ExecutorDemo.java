package com.bite.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author tjy
 * @Date 2020/6/30 16:03
 */

public class ExecutorDemo {
    /**
     * final的引用集合，集合可以添加删除元素，但不能指向其他的集合，只能指向创建的集合对象。
     */
    public static final Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

        set.add(5);
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100000; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            System.out.println(executorService.isShutdown());
//        }
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println(executorService1.isShutdown());
        }



    }




}
