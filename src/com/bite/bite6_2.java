package com.bite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/3 12:36
 */

public class bite6_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        while (sc.hasNext()){
            int x = sc.nextInt();
            if (x == 0)break;
            queue.offer(x);
        }
        int empty;
        int drink;
        int title = 0;
        while (!queue.isEmpty()) {
            empty = queue.poll();
            while (empty >= 3){
                drink = empty / 3;
                title += drink;
                empty -= drink*3;
                empty += drink;
            }
            if (empty == 2)title++;
            res.offer(title);
            title = 0;
        }

        for (int x: res) {
            System.out.println(x);
        }
    }

    public int count(int[] A, int n) {
        // write code here
        if (n == 0)return 0;
        return  meger(A,0,n-1);
    }

    private int meger(int[] a,int left,int right) {
        if (left >= right) return 0;
        int mid = (left + right) >>> 1;
        return meger(a, left, mid)+
                meger(a, mid + 1, right)+
                meger1(a,left,mid,right);
    }

    private int meger1(int[] a,int left,int mid,int right){
        int count = 0;
        int s1 = left;
        int s2 = mid + 1;
        int[] res = new int[right - left + 1];
        int i = 0;
        while (s1 <= mid && s2 <= right){
            if (a[s1] <= a[s2]){
                res[i++] = a[s1++];
            }else {
                res[i++] = a[s2++];
                count += mid - i + 1;
            }
        }

        while (s1 <= mid){
            res[i++] = a[s1++];

        }

        while (s2 <= right){
            res[i++] = a[s2++];
        }

        for (int j = 0; j < res.length; j++) {
            a[left + j] = res[j];
        }
        return count;
    }
}
