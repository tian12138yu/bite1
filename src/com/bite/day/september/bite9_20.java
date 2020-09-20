package com.bite.day.september;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/20 13:37
 */

public class bite9_20 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, int i, ArrayList<Integer> al) {
        res.add(new ArrayList<>(al));
        for (int j = i; j < nums.length; j++) {
            al.add(nums[j]);
            dfs(nums,i+1,al);
            al.remove(al.size()-1);
        }
    }


}
