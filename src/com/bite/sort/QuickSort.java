package com.bite.sort;

/**
 * @Author tjy
 * @Date 2020/5/24 14:41
 */

import java.util.Stack;

/**
 * 当快排进行多次后，数组就趋于有序，就可以用直接插入排序，优化排序速度。
 */
public class QuickSort {

    public void sort(int[] array){

    }

    /**
     * 时间复杂度：O(nlogn)最坏：O(n^2)
     * 空间复杂度：O(longn)最坏：O(n)
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array,int low,int high) {
        if (low >= high)return low;
        int temp = array[low];
        while (low < high){
            while (array[high] > temp && low < high){
                high--;
            }
            array[low] = array[high];
            while (array[low] <= temp && low < high){
                low++;
            }
            array[high] = array[low];

        }
        array[low] = temp;

        return low;
    }

    public static void three_num_mid(int[] array,int left,int right) {
        //array[mid] <= array[left] <= array[high]
        int mid = (left + right) / 2;
        if (array[mid] <= array[left]
                && array[left] <= array[right])return;


    }

    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int partition = partition(array,left,right);
        quick(array,left,partition - 1);
        quick(array,partition+1,right);

    }
    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;
        int par = partition(array,left,right);
        if(par > left+1) {
            stack.push(left);
            stack.push(par - 1);
        }
        if(par < right-1) {
            stack.push(par + 1);
            stack.push(right);
        }

        while (!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            par = partition(array,left,right);
            if(par > left+1) {
                stack.push(left);
                stack.push(par - 1);
            }
            if(par < right-1) {
                stack.push(par + 1);
                stack.push(right);
            }
        }


    }

}
