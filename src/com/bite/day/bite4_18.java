package com.bite.day;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/4/18 13:01
 */

public class bite4_18 {

    public static void main(String[] args) {
        int[] a = {5 ,3,5,4,8,6,2 };
//        swap(a);
//        System.out.println(Arrays.toString(a));
        int[] b = {5,6,478,5,7,2,8};
        swapArray(a,b);
        System.out.println(Arrays.toString(a)+Arrays.toString(b));
    }

    /**
     * 给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
     */

    public static void swap(int[] a){

        int x = 0;int y = a.length-1;
        while(x < y){

            for (; x < a.length; x++){
                if (a[x]%2 != 0){
                    break;
                }
            }

            for (; y >= 0; y--){
                if (a[y]%2 == 0){
                    break;
                }
            }

            if (x<y){
                int temp=a[x];
                a[x]=a[y];
                a[y]=temp;
            }

        }
    }

    /**
     * 给定两个整型数组, 交换两个数组的内容.
     * @param a
     * @param b
     */

    public static void swapArray(int[] a,int[] b){
        for (int x = 0; x < a.length; x++){
            a[x] = a[x] ^ b[x];
            b[x] = a[x] ^ b[x];
            a[x] = b[x] ^ a[x];
        }

    }
}
