package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/23 20:01
 */

public class bite8_23 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        while ((s = br.readLine()) != null) {
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            String[] s2 = br.readLine().split(" ");
            for (int i = 0; i < n-1; i++) {
                if (i == k-1)continue;
                System.out.print(s2[i] + " ");
            }
            System.out.println(s2[n-1]);
        }
    }

    static PriorityQueue<String> strings;
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        while ((s = br.readLine()) != null) {
            int k = Integer.parseInt(br.readLine());
            strings = new PriorityQueue<>(k, (o1, o2) -> {
                 int len1 = o1.length();
                 int len2 = o2.length();
                 int lim = Math.min(len1, len2);
                 char[] v1 = o1.toCharArray();
                 char[] v2 = o2.toCharArray();

                 int k1 = 0;
                 while (k1 < lim) {
                     char c1 = v1[k1];
                     char c2 = v2[k1];
                     if (c1 != c2) {
                         return c2 - c1;
                     }
                     k1++;
                 }
                 return len2 - len1;
            });

            for (int i = 0; i < s.length(); i++) {
                dfs(s,i,k);
            }

            System.out.println(strings);
            System.out.println(strings.peek());
//            System.out.println(set);
        }



    }

    private static void dfs(String s, int i,int k) {

        for (int j = 1; j <= s.length() - i; j++) {
            String substring = s.substring(i, i + j);
            if (strings.size() < k || substring.compareTo(strings.peek()) < 0)
                strings.add(substring);
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            for (int i = 0; i < n; i++) {
                Long l = Long.parseLong(br.readLine());
                long res = Max(l);
                System.out.println(res);
            }
        }

    }

    private static long Max(Long l) {
        long max = 0;
        for (long i = 1; i < (l >>> 1); i++) {
            long l1 = l - i;
            long temp = 0;
            String s1 = String.valueOf(i);
            String s2 = String.valueOf(l1);
            for (int j = 0; j < s1.length(); j++) {
                temp += s1.charAt(j) - '0';
            }

            for (int j = 0; j < s2.length(); j++) {
                temp += s2.charAt(j) - '0';
            }
            if (temp > max)
                max = temp;
        }
        return max;
    }

    public static void main4(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            String[] s1 = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            TreeSet<Integer> set = new TreeSet<>(((o1, o2) -> o2 - o1));
            for (int i = 0; i < s1.length; i++) {
                sb.append(s1[i]);
                set.add(Integer.parseInt(s1[i]));
            }

            String s3 = sb.toString();
//            System.out.println(s3);
            int count = 0;
            int min = 0;
            for (int x : set) {
                min = x;
                count++;
//                System.out.println(x);
                int i1 = s3.indexOf(x+"");
//                System.out.println(i1);
                int i2 = s3.lastIndexOf(x+"");
//                System.out.println(i2);
                for (int j = i1 + 1; j < i2; j++) {
                    if (Integer.parseInt(s1[j])  < x)
                        count++;
                }
            }
            if (min != 1)
                count += min - 1;

            System.out.println(Math.min(n,count));
        }
    }

    public static void main(String[] args) {
        System.out.println("dasasd".substring(1,1));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
