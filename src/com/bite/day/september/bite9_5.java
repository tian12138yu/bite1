package com.bite.day.september;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/5 18:08
 */

public class bite9_5 {
    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     *
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     *
     * 说明：
     *
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     *
     * 输入: n = 3, k = 3
     * 输出: "213"
     *
     */
    static int temp = 0;
    static List<String> al = new ArrayList<>();
    public static String getPermutation(int n, int k) {
        int[] array = new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
        dfs(array,1);
        return al.get(k-1);
    }

    private static void dfs(int[] a,int x) {
        if (x == a.length-1)return;
        String s = "";
        for (int i = 1; i < a.length; i++) {
            s += a[i];
        }
        al.add(s);

        for (int i = x+ 1; i < a.length; i++) {
            swap(a,x,i);
            dfs(a,x+1);
            swap(a,x,i);
        }
    }

    private static void swap(int[] a,int x, int i) {
        int c = a[x];
        a[x] = a[i];
        a[i] = c;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
