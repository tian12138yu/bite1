package com.bite.thread;

/**
 * @Author tjy
 * @Date 2020/6/14 11:50
 */

public class ThreadSpeedUp {

    private static final long C = 10;
    private static final long N = 10_0000_0000L;

    private static class Calc extends Thread {
        @Override
        public void run() {
            long r = 0;
            for (long i = 0; i < N; i++) {
                r += i;
            }
            System.out.println(r);
        }
    }

    private static void 并行方式计算() throws InterruptedException {
        long b = System.currentTimeMillis();
        // 一共启动 C 个线程执行
        // 需要再启动 C - 1 个线程
        // 每个线程，只需要计算 1 + ... + N 就可以了
        Calc[] threads = new Calc[(int)C - 1];
        for (int i = 0; i < C - 1; i++) {
            threads[i] = new Calc();
            threads[i].start();
        }

        // 主线程中，自己选一次 1 + ... + N
        long r = 0;
        for (long i = 0; i < N; i++) {
            r += i;
        }
        System.out.println(r);

        // 必须等待其他 N - 1 个线程执行结束，才算真正执行结束
        for (int i = 0; i < C - 1; i++) {
            threads[i].join();
        }
        long e = System.currentTimeMillis();

        System.out.printf("并行模式下，耗时: %.2f秒%n", (e - b) / 1000.0);
    }

    private static void 串行方式计算() {
        long b = System.currentTimeMillis();
        for (long j = 0; j < C; j++) {
            long r = 0;
            for (long i = 0; i < N; i++) {
                r += i;
            }
            System.out.println(r);
        }
        long e = System.currentTimeMillis();

        System.out.printf("串行模式下，耗时: %.2f秒%n", (e - b) / 1000.0);
    }

    public static void main(String[] args) throws InterruptedException {
        // 预热，防止影响速度
        for (int i = 0; i < 20; i++) {
            long r = 0;
            for (long j = 0; j < N; j++) {
                r += j;
            }
        }
        串行方式计算();
        并行方式计算();
    }
}
