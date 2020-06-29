package com.bite.socket;

import java.util.Date;

/**
 * @Author tjy
 * @Date 2020/6/29 19:29
 */

public class Logger {
    public static void debug(String message) {
        System.out.printf("%s %s: DEBUG: %s%n", Thread.currentThread().getName(),new Date(), message);
    }
}
