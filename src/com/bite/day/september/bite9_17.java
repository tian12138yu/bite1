package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/9/17 13:53
 */

public class bite9_17 {

    public int search (int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length;
        int mid ;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (nums[mid] == target)
                return nums[mid];

            else if (nums[mid] < target)
                left = mid ;
            else
                right = mid ;
        }
        return -1;
    }

    public boolean isPowerOfTwo (int n) {
        // write code here
        if (n == 1)return true;int x = 0;
        while (n != 0) {
            n ^= n - 1;
            x++;
        }
        return x == 1;
    }
}
