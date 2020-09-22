package com.bite.day.september;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        int length = arr.length;
        if (pushOffset > length) {
            pushOffset = pushOffset % length;
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[(i + pushOffset) % length] = arr[i];
        }

        return res;
    }


    public int sort (String inData) {
        // write code here
        String[] s = inData.split(" ");
        int len = s.length;
        int[] a= new int[len];
        int[] a1 = new int[len];
        for (int i = 0; i < len; i++) {
            int x = Integer.parseInt(s[i]);
            a[i] = x;
            a1[i] = x;
        }

        Arrays.sort(a1);
        int count = 0;
        int y = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == a1[y]){
                ++count;
                ++y;
            }
        }

        return len - count;

    }
}
