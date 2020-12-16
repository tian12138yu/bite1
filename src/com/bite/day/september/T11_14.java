package com.bite.day.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tjy
 * @Date 2020/11/14 12:15
 */

public class T11_14 {

    /**
     * 给你两个数组，arr1 和 arr2，
     *
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
     * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     *  
     *
     * 示例：
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     */

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> al = new ArrayList<>();
        for (int x : arr1) {
            al.add(x);
        }

        int i = 0;
        int k = 1;
        int len = arr1.length;
        for (int j = 0; j < arr2.length; j++) {

            while (al.contains(arr2[j])) {
                arr1[i] = arr2[j];
                i++;
                al.remove(al.indexOf(arr2[j]));
            }

        }
        if (!al.isEmpty()) {
            for (int j = 0; j < al.size(); j++) {
                arr1[len - j - 1] = al.get(j);
            }
        }


        Arrays.sort(arr1,len - al.size() ,len);
        return arr1;
    }

    public static void main(String[] args) {
        int[] a1 = {26,21,11,20,50,34,1,18};
        int[] a2 = {21,11,26,20};
        int[] ints = relativeSortArray(a1, a2);
        System.out.println(Arrays.toString(ints));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("sb");
            }
        }).start();

        new ReentrantLock(true);


    }
}
