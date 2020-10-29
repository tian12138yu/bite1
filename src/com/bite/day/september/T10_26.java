package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/10/26 21:01
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 */
public class T10_26 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> als = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            als.add(null);
        }
        for (int i = 0; i < nums.length; i++) {
            if (al.contains(nums[i])) {
                List<Integer> al1;
                if (als.get(nums[i]) == null) {
                    al1 = new ArrayList<>();
                    al1.add(i);
                    al1.add(al.indexOf(nums[i]));
                    als.set(nums[i],al1);
                }else {
                    al1 = als.get(nums[i]);
                    al1.add(i);
                }

            }

            al.add(nums[i]);


        }

        Arrays.sort(nums);
        int[] res = new int[nums.length];

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (als.get(nums[i]) == null) {
                int index = al.indexOf(nums[i]);
                res[index] = temp;
                temp++;
            }else {
                int z = temp;
                List<Integer> list = als.get(nums[i]);
                for (int x : list) {
                    res[x] = z;
                    temp++;
                    i++;
                }
                i--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {8,1,2,2,3};
        int[] ints = smallerNumbersThanCurrent(a);
        System.out.println(Arrays.toString(ints));
    }





}
