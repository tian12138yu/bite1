package com.bite.File;

import java.io.*;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/26 19:23
 */

public class ReadAndWrite {
    /**
     * 复制一个文件。
     * @param args
     */
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("a.txt");
            InputStreamReader isr = new InputStreamReader(is);

            FileOutputStream fs = new FileOutputStream("b.txt");

            byte[] b = new byte[1024];
            int n ;
            while ((n = is.read(b)) != -1){
                fs.write(b);
            }
            fs.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
