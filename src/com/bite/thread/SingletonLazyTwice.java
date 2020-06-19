package com.bite.thread;

/**
 * @Author tjy
 * @Date 2020/6/19 20:08
 */

public class SingletonLazyTwice {
    private static volatile SingletonLazyTwice instance = null;
    //volatile保证指令重排序取消，因为可能返回的对象未初始化完成。
    // 以下写法是线程安全的么？
    // 不是
    // 这把锁加的毫无意义
    public static SingletonLazyTwice getInstanceUnsafe() {
        if (instance == null) {
            synchronized (SingletonLazyTwice.class) {
                instance = new SingletonLazyTwice();
            }
        }

        return instance;
    }

    // 通过二次判断，既保证了线程安全，又减少了抢锁的次数
    public static SingletonLazyTwice getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyTwice.class) {
                // instance 可能是 null，也可能不是 null
                if (instance == null) {
                    // 这里因为锁的存在，只会执行一次
                    // 保证了单例
                    instance = new SingletonLazyTwice();
                } else {
                    // 抢锁之前，instance 是 null
                    // 但是从抢锁到抢锁成功这段期间
                    // instance 已经不是 null
                    // 代表已经被之前抢到锁的线程实例化好了
                    // 也就什么都不需要做了
                }
            }
        }

        return instance;
    }

    private SingletonLazyTwice() {}
}

