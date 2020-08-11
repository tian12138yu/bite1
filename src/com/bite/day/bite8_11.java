package com.bite.day;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/11 11:00
 */

public class bite8_11 {

    public static int GetUglyNumber_Solution(int index) {
        int[] a = {2,3,5};
        int[] res = new int[index];
        res[0] = 1;
        int x = 0;
        int y =0;
        for (int i = 1; i < index; i++) {
            res[i] = res[y] * a[x];
            x++;
            if (x == 3){
                x = 0;
                y++;
            }
        }
        Arrays.sort(res);
        return res[res.length -1];
    }

    public static void main1(String[] args) {
        System.out.println(GetUglyNumber_Solution(6));
    }

    public int FirstNotRepeatingChar(String str) {

        for (int i = 0; i < str.length(); i++) {
           if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)))
                   return i;
        }

        return -1;
    }
    static int count = 0;
    public static int InversePairs(int [] array) {
        spilit(array,0,array.length-1);
        return count;
    }

    private static void mergeSplit(int[] array, int low, int high) {
        if (low >= high)return;
        int mid = (low + high) >>> 1;
        mergeSplit(array,low,mid);
        mergeSplit(array,mid+1,high);
        merger(array,low,mid,high);
        count %= 1000000007;
    }

    private static void merger(int[] array, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int x  = 0;
        while (left <= mid && right <= high){
            while (left <= mid && array[left] < array[right]){
                temp[x++] = array[left++];
            }

            while (right <= high && array[left] > array[right]){
                temp[x++] = array[right++];
                count += mid - left + 1;
            }
        }

        while (left <= mid){
            temp[x++] = array[left++];
        }

        while (right <= high){
            temp[x++] = array[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }

    }

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
                count += mid - s1 + 1;
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

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(a));
    }
}
