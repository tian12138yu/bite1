package com.bite.day.september;

import java.io.*;

/**
 * @Author tjy
 * @Date 2020/9/21 12:50
 */

public class bite9_21 {

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(new File("D+"));
        writer.write("sada");
        writer.append("fada");
        new Thread(() -> {

        });
    }
}
