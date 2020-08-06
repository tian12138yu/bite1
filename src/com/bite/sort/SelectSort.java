package com.bite.sort;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/22 20:51
 */

public class SelectSort {
    /**
     * 时间复杂：O(n^2)
     * 空间复杂度O(1)
     * 不稳点，交换是跨越式交换
     * @param array
     */
    public static void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1 ; j < array.length; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }

    }

    public static void main(String[] args) {
        int[] a = {900,512,613,700,810};
        sort(a);
    }
}
