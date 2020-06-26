package com.bite.File;

/**
 * @Author tjy
 * @Date 2020/6/26 19:03
 */

import java.io.*;
import java.util.Scanner;

/**
 * 通过scanner读取数据，可以读一行或者其他要求。
 */
public class ReadTemplateDemo {
    public static void 字符数据1() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                }
            }
        }
    }

    public static void 字符数据2() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            try (Scanner scanner = new Scanner(is, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        }
    }

    public static void 字节数据() throws IOException {
        try (InputStream is = new FileInputStream("测试目录\\logo.png")) {
            byte[] buffer = new byte[1024];
            int n;

            while ((n = is.read(buffer)) != -1) {
                // 使用 buf[0:n)
            }
        }
    }
}
