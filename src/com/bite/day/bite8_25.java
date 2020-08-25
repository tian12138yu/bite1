package com.bite.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/8/25 18:43
 */

public class bite8_25 {

    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     *
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> als = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dfs(i,nums,als,set);
        }
        return als;
    }

    private void dfs(int i ,int[] nums, List<List<Integer>> als, HashSet<String> set) {
        StringBuilder sb = new StringBuilder(nums[i]);
        List<Integer> al = new ArrayList<>();
        int temp = nums[i];
        al.add(temp);
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] >= temp){
                al.add(nums[j]);
                sb.append(nums[i]);
                if (set.add(sb.toString())){
                    als.add(al);
                }
            }
        }
    }


    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences1(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

}
