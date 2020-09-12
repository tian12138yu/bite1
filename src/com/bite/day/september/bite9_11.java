package com.bite.day.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/11 9:47
 */

public class bite9_11 {

    /**
     *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     *
     */
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k <= 0)return new ArrayList<>();
        res = new ArrayList<>();
        int min = Math.min(10, n >>> 1);
        for (int i = 1; i < min; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(i);
            dfs(i,i,al,k,n);
        }
        return res;
    }

    private static void dfs(int i, int sum, ArrayList<Integer> al, int k, int n) {

        if (sum == n && al.size() == k){
            res.add(new ArrayList<>(al));
        }

        if (sum > n || al.size() >= k)return;

        for (int j = i+1; j < 10; j++) {
            al.add(j);
            dfs(j,sum+j,al,k,n);
            al.remove(al.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));

    }
}
