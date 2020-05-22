package com.bite.sort;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/22 18:59
 */

public class InsertSort {

    /**
     * 时间复杂度：最坏：O(n^2)，最好O(n)。
     * 空间复杂度：O(1)
     */
    static int[] elem = {5,6,1,3,8,9};
    public static void main(String[] args) {
        for (int i = 1; i < elem.length; i++) {
            int temp = elem[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if (elem[j] > temp){
                    elem[j + 1] = elem[j];
                }else {
                    break;
                }
            }
            elem[j + 1] = temp;
        }
        System.out.println(Arrays.toString(elem));
    }
}
