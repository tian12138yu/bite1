package com.bite.sort;

/**
 * @Author tjy
 * @Date 2020/5/22 20:18
 */

public class SheelSort {

    public static void shell(int[] array,int gap) {

        for (int i = gap; i < array.length; i ++) {
            int temp = array[i];
            int j = i - gap;
            for (; j >= 0 ; j -= gap) {
                if (array[j] > temp){
                    array[j + gap] = array[j];
                }else {
                    break;
                }
            }
            array[j + gap] = temp;
        }
    }

    public static  void  shellSort(int[] array) {

        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }

    }
}
