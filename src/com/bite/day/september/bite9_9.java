package com.bite.day.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/9 9:44
 */

public class bite9_9 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     */
    List<List<Integer>> als;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (sum + candidates[j]> target)break;
            if (sum + candidates[j] <= target){
                al.add(candidates[j]);
                dfs(candidates,j,sum+candidates[j],target,al);
                al.remove(al.size()-1);
            }
        }


    }
}
