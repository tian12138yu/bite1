package com.bite.day;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/2 10:57
 */

public class bite6_1 {
    /**
     * 插入字符串构成回文串。
     * @param args
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        int count = 0;
//        for (int i = 0; i <= s1.length(); i++) {
//            StringBuilder sb = new StringBuilder(s1);
//            sb.insert(i,s2);
//            if (isHuiwen(sb.toString())) {
//                count++;
//            }
//
//        }
//        System.out.println(count);
        int[] a = {5,3,6,7,4,2};
        System.out.println(findKth(a, 6, 2));
    }

    private static boolean isHuiwen(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 寻找第K大的数
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        // write code here

        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        return a[n - K];
    }

    private static void sort(int[] a,int left,int right){
        if (left >= right)return;
        int low = left;
        int high = right;
        int temp = a[low];
        while (low < high) {
            while (a[high] >= temp && low < high) {
                high--;
            }
            a[low] = a[high];
            while (a[low] <= temp && low < high) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        sort(a,left,low-1);
        sort(a,low+1,right);
    }
}
