package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @Author tjy
 * @Date 2020/9/8 9:42
 */

public class bite9_8 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    static List<List<Integer>> als = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        if (k > n)return als;
        dfs(0,n,k,new ArrayList<>());

        return als;
    }

    private static void dfs(int i, int n, int k, List<Integer> al) {
        if (al.size() == k){
            als.add(new ArrayList<>(al));
            return;
        }

        for (int j = i+1; j <= n; j++) {
            al.add(j);
            dfs(j,n,k,al);
            al.remove(al.size() - 1);

        }
    }

//    private static void dfs(int i, int k, List<Integer> al,List<Integer> temp) {
//        if (i == k) {
//            als.add(new ArrayList<>(temp));
//            return;
//        }
//
//        for (int x : al){
//            if (!temp.contains(x)){
//                temp.add(x);
//                dfs(i+1,k,al,temp);
//                temp.remove(temp.size() - 1);
//            }
//        }
//
//    }


    public static void main1(String[] args) {
        System.out.println(combine(4,2));
        Executors.newFixedThreadPool(10);

    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < 8 || s[i].length() > 120){
                System.out.println(1);
                continue;
            }
            boolean b = isTrue(s[i]);
            if (b)
                System.out.println(0);
            else
                System.out.println(2);
        }
    }

    private static boolean isTrue(String s) {
        boolean[] b = new boolean[4];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i]))
                b[0] = true;
            else if (Character.isUpperCase(chars[i]))
                b[1] = true;
            else if (Character.isDigit(chars[i]))
                b[2] = true;
            else
                b[3] = true;
        }

        boolean res = true;
        for (boolean temp : b){
            res &= temp;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            Random random = new Random();
            int x = random.nextInt(898564654);
            if (x % 2 == 0)
                System.out.println(true);
            else
                System.out.println(false);
        }
    }
}
