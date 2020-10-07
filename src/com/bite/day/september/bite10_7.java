package com.bite.day.september;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/10/7 19:23
 */

public class bite10_7 {

    public void sortColors(int[] nums) {
        if (nums.length == 0)return;
        List<Integer> al0= new ArrayList<>();
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                al0.add(0);
            }else if (nums[i] == 2) {
                al2.add(2);
            }else {
                al1.add(1);
            }
        }
        int temp = 0;
        for (int i = 0; i < al0.size(); i++) {
            nums[temp] = 0;
            temp++;
        }

        for (int i = 0; i < al1.size(); i++) {
            nums[temp] = 1;
            temp++;
        }

        for (int i = 0; i < al2.size(); i ++) {
            nums[temp] = 2;
            temp++;
        }
    }

    public static void main(String[] args) {

    }
}
