package com.bite.sort;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/22 21:03
 */

/**
 * 时间复杂度：O（N*logn）
 * 空间复杂度：O（1）
 */
public class HeapSort {

    public static void creatHeap(int[] array,int len){
        for (int i = (len -2) / 2; i >= 0; i--) {
            adjustDown(array,i,len);
        }
    }

    private static void adjustDown(int[] array, int i, int len) {
        int parent = i;
        int child = parent *2 +1;
        while (child < len){
            if (child + 1 < len && array[child] > array[child + 1])
                child++;
            if (array[child] < array[parent]){
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                parent = child;
                child = child * 2+1;
            }else {
                break;
            }
        }
    }
    private static void sort(int[] array){
        int end = array.length - 1;
        while (end > 0){
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            adjustDown(array,0,end);
            end--;
        }
    }

    public static void main(String[] args) {
        int[] elem = {5,6,1,3,8,9};
        creatHeap(elem,elem.length);
        System.out.println(Arrays.toString(elem));
        sort(elem);
        System.out.println(Arrays.toString(elem));
    }

}
