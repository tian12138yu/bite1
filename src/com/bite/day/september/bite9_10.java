package com.bite.day.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/10 18:18
 */

public class bite9_10 {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     */

    List<List<Integer>> als;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)return new ArrayList<>();
        als = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,0,0,target,new ArrayList<>());
        return als;
    }

    private void dfs(int[] candidates,int i, int sum, int target,List<Integer> al) {
        if (sum == target){
            als.add(new ArrayList<>(al));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] == candidates[j-1])
                continue;
            if (sum + candidates[j]> target)break;
            if (sum + candidates[j] <= target){
                al.add(candidates[j]);
                dfs(candidates,j,sum+candidates[j],target,al);
                al.remove(al.size()-1);
            }
        }

    }


    public static int combination (int r, int n) {
        // write code here
        int res = 1;
        for (int i = n; i > r; i--) {
            res *= i;
        }
        return res;
    }


    public int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        // write code here
        int x = 0;
        int y = m-1;
        int z = 0;
        int[] res = new int[n+m];
        while (x < n && y >= 0) {
            if (array1[x] < array2[y]){
                res[z] = array1[x];
                x++;
            }

            else if (array1[x] >= array2[y]){
                res[z] = array2[y];
                z--;
            }
            z++;
        }
        while (x < n){
            res[z++] = array1[x++];
        }

        while (y >= 0){
            res[z++] = array2[y--];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(combination(3, 5));
    }




}
