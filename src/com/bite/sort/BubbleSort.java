package com.bite.sort;

/**
 * @Author tjy
 * @Date 2020/5/22 21:20
 */

public class BubbleSort {

    public void sort(int[] array){
        boolean isSort;
        for (int i = 0; i < array.length-1; i++) {
            isSort = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSort = true;
                }
            }
            if (!isSort)break;
        }
    }

}
