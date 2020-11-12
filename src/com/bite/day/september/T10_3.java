package com.bite.day.september;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author tjy
 * @Date 2020/11/3 22:36
 */

public class T10_3 {

    /**
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     *
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     *
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *
     */
    public static boolean validMountainArray(int[] A) {
        int i = 1;
        while (i < A.length && A[i - 1] < A[i]) {
            i++;
        }

        if (i == A.length || i == 1)
            return false;

        while (i < A.length - 1 && A[i] > A[i + 1]){
            i++;
        }

        if (i != A.length - 1)
            return false;
        return A[i - 1] > A[i];
    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray(a));

        new ArrayList<>();
        new LinkedList<>();
    }
}
