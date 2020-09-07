package com.bite.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tjy
 * @Date 2020/9/7 18:33
 */

public class ConditionDemo {
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    int num = 1;
    public void printA(){
        lock.lock();
        try {
            while (num != 1){
                c1.await();
            }
            num = 2;
            System.out.println("我是A，下一个是B");
            c2.signal();
        }catch (Exception e ){
            System.out.println(e);
        }finally {
            lock.unlock();
        }

    }

    public void printB(){
        lock.lock();
        try {
            while (num != 2){
                c2.await();
            }
            num = 3;
            System.out.println("我是B，下一个是C");
            c3.signal();
        }catch (Exception e ){
            System.out.println(e);
        }finally {
            lock.unlock();
        }

    }

    public void printC(){
        lock.lock();
        try {
            while (num != 3){
                c3.await();
            }
            num = 1;
            System.out.println("我是C，下一个是A");
            c1.signal();

        }catch (Exception e ){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionDemo.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                conditionDemo.printB();

            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                conditionDemo.printC();
            }
        }).start();


    }


}
