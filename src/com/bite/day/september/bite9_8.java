package com.bite.day.september;

import java.util.ArrayList;
import java.util.List;
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


    public static void main(String[] args) {
        System.out.println(combine(4,2));
        Executors.newFixedThreadPool(10);

    }
}
