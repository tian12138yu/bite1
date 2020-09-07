package com.bite.day.september;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/9/7 13:49
 */

public class bite9_7 {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> entries = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entries.size() < k)
                entries.offer(entry);
            else if (entry.getValue() > entries.peek().getValue()){
                entries.poll();
                entries.offer(entry);
            }
        }

        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(entries.poll().getKey());
        }

        for (int i = 0; i < k; i++) {
            res[i] = stack.pop();
        }

        return res;

    }


    /**
     * 基于快排寻找第K大的数
     * @param nums
     * @param k
     * @return
     */
    public static int findKth(int[] nums ,int k ) {
        return quickSort(nums,0,nums.length - 1, k);
    }

    private static int quickSort(int[] nums, int low, int high, int k) {
        if (low > high)return -1;
        int left = low;
        int right = high;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp)
                right--;

            nums[left] = nums[right];

            while (left < right && nums[left] <= temp)
                left++;

            nums[right] = nums[left];
        }

        if (left ==  k-1)
            return temp;
        else if (left < k-1)
            return quickSort(nums,left + 1,high,k);
        else
            return quickSort(nums,low,left - 1,k);

    }

    public static void main(String[] args) {
        int[] a = {8,9,10,11,12,13,14};
        System.out.println(findKth(a, 5));
    }
}
