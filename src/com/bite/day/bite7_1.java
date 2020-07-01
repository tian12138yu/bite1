package com.bite.day;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/1 13:51
 */

public class bite7_1 {

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        in :while (sc.hasNext()){
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int find = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (array[i] == find){
                    System.out.println(i);
                    break in;
                }
            }
            System.out.println(-1);
        }

    }

    /**
     * 10.0.3.193
     * 167969729
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] split = s.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                String s1 = Integer.toBinaryString(Integer.parseInt(split[i]));
                int x = 8 - s1.length();
                for (int j = 0; j < x; j++) {
                    sb.append("0");
                }
                sb.append(s1);
            }
            System.out.println(Long.parseLong(sb.toString(),2));
            String s2 = br.readLine();
            long l = Long.parseLong(s2);
//            String s1 = Long.toBinaryString(l);
//            StringBuilder sb2 = new StringBuilder();
//            for (int i = 0; i < 32 - s1.length(); i++) {
//                sb2.append("0");
//            }
//            sb2.append(s1);
//            s1 = sb2.toString();
            StringBuilder res = new StringBuilder();

            res.append(((l >> 24) & 255)).append(".").append(((l >> 16) & 255))
                    .append(".").append(((l >> 8) & 255)).append(".").append((l & 255));

            System.out.println(res.toString());
        }
    }

    public static void main4(String[] args) {
//        long n = 167969729;
//        System.out.println(Long.toBinaryString(n));
//        System.out.println(Integer.parseInt("11111111", 2));
        System.out.println((10101010 & 255));
    }
}
