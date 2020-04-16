package com.bite;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/4/16 13:53
 */

public class bite4_16 {

    public static void main(String[] args) {
        int[] a={4,5,2,6,8,1};
//        int i = binarySearch(a, 6);
//        maopao(a);
        String s = arrayToString(a);
        System.out.println(s);
    }

    /**
     * 给定一个整型数组, 实现冒泡排序(升序排序)
     */

    public static void maopao(int[] sum){
        boolean a;
        for (int x = 0; x < (sum.length)/2+1; x++ ){
            a=true;
            for (int i = 1; i < sum.length; i++ ){
                if (sum[i-1] > sum[i]){
                    swap(i-1,i,sum);
                    a=false;
                }
            }

            if (a){
                break;
            }

            for (int j = sum.length-1; j > 0; j-- ){
                if (sum[j] < sum[j-1]){
                    swap(j,j-1,sum);
                    a=false;
                }
            }

            if (a){
                break;
            }
        }
    }

    private static void swap(int i, int i1,int[] sum) {
        int temp=sum[i];
        sum[i]=sum[i1];
        sum[i1]=temp;
    }

    /**
     * 给定一个整型数组, 判定数组是否有序（递增）
     */

    public static boolean orderArray(int[] sum){
        for (int x = 1; x < sum.length; x++ ){
            if (sum[x-1]>sum[x]){
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个有序整型数组, 实现二分查找
     */

    public static int binarySearch(int[] sum,int target){
        int fir = 0;
        int last = sum.length-1;
        int mid;
        while( fir <= last ){
            mid = ( fir + last )/2;
            if ( sum[mid] > target ){
                last = mid-1;
            }
            if (sum[mid] < target){
                fir = mid+1;
            }
            if (sum[mid] == target){
                return mid;
            }
        }

        return -1;
    }

    /**
     * 实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
     */

    public static int[] arrayCopy(int[] sum){
        int[] copy = new int[sum.length];
        for (int x = 0; x < sum.length; x++ ){
            copy[x] = sum[x];
        }
        return copy;
    }

    /**
     * 实现一个方法 toString, 把一个整型数组转换成字符串.
     * 例如数组 {1, 2, 3} ,
     * 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
     */

    public static String arrayToString(int[] sum){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int x = 0; x < sum.length; x++){
            stringBuilder.append(sum[x]);
            if (x != sum.length-1)
            stringBuilder.append(",");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();

    }


}
