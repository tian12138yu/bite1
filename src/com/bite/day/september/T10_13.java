package com.bite.day.september;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author tjy
 * @Date 2020/10/13 10:52
 */

public class T10_13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int k = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i < k; i++) {
                String s1 = br.readLine();
                int x = fun(s1,n);
                sum += x;
            }
            System.out.println(sum);
        }
    }

    private static int fun(String s1,int n) {
        String[] split = s1.split(",");
        return Integer.parseInt(split[split.length - n]);
    }
}
