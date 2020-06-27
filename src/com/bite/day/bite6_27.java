package com.bite.day;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/27 13:10
 */

public class bite6_27 {

    /**
     * 判断当前顺序是否是快排第几次的结果，可以看有几个数归位，快排执行一次至少有一个归位。
     */

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int res = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] <= res){
                    res += a[i];
                }else {
                    res += MaxNum(res,a[i]);
                }
            }

            System.out.println(res);

        }

    }

    private static int MaxNum(int res, int i) {
        if (res < i){
            int temp = res;
            res = i;
            i = temp;
        }
        int temp = res % i;
        while (temp != 0){
            res = i;
            i = temp;
            temp = res % i;
        }

        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                String s = sc.next();
                if (s .equals("Q")){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if (x > y){
                        int temp = x;
                        x = y;
                        y = temp;
                    }
                    int max = 0;
                    for (int j = x - 1; j < y; j++) {
                        if (a[j] > max)max = a[j];
                    }
                    System.out.println(max);
                }
                else if (s .equals("U")){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    a[x-1] = y;
                }
            }
        }
    }
}
