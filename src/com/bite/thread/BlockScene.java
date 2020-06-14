package com.bite.thread;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/14 11:50
 */

public class BlockScene {

    private static long fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private static class FibThread extends Thread {
        private final int n;

        FibThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.printf("fib(%d) = %d%n", n, fib(n));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 主线程只负责接待客人
            int n = scanner.nextInt();
            //System.out.printf("fib(%d) = %d%n", n, fib(n));
            new FibThread(n).start();   // 每次计算交给一个新人去处理
        }
    }
}
