package com.bite.sort;

/**
 * @Author tjy
 * @Date 2020/5/24 17:05
 */

import java.util.Arrays;

/**
 * 先将数组分成一个一个的数组，在把分开的一个一个排序，然后往上返回，最后成有序的
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳点的排序。
 */
public class MergeSort {
    public static void spilit(int[] array,int left,int right){
        if (left >= right)return;
        int mid = (left + right) / 2;
        spilit(array,left,mid);
        spilit(array,mid+1,right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] res = new int[right - left + 1];
        int i = 0;
        while (s1 <= mid && s2 <= right){
            if (array[s1] <= array[s2]){
                res[i++] = array[s1++];
            }else {
                res[i++] = array[s2++];
            }
        }

        while (s1 <= mid){
            res[i++] = array[s1++];
        }

        while (s2 <= right){
            res[i++] = array[s2++];
        }

        for (int j = 0; j < res.length; j++) {
            array[left + j] = res[j];
        }
    }

    public static void merge1(int[] array,int low,int mid,int high) {
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1;
        int[] ret = new int[len];
        int i = 0;//用来表示ret数组的下标

        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                ret[i++] = array[s1++];
            }else {
                ret[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            ret[i++] = array[s1++];
        }

        while (s2 <= high) {
            ret[i++] = array[s2++];
        }

        for (int j = 0; j < ret.length; j++) {
            array[j+low] = ret[j];
        }

    }

    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) {
            return;
        }
        //分解
        int mid = (low+high)>>>1;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge1(array,low,mid,high);
    }

    public static void main(String[] args) {
        int[] elem = {5,6,1,3,8,9};
        spilit(elem,0,elem.length-1);
        System.out.println(Arrays.toString(elem));
    }
}
