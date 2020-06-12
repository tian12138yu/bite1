package com.bite.day;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/12 14:27
 */

public class bite6_11 {

    public static void main1(String[] args) {
        double s;
    }
    public final static  native  int w();

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 1;
        int y = 1;
        while (x + y < n){
            int temp = y;
            y = x + y;
            x = temp;
        }
        int min = Math.min(n - y, x + y - n);
        System.out.println(min);

    }

    public static void main(String[] args) {
        int i = countWays(2, 2);
        System.out.println(i);
    }

    public static int countWays(int x, int y) {
        // write code here
        if (x == y && x == 0)return 0;
        int res = dfs(0,0,x,y);
        return res;
    }

    private static int dfs(int i, int j, int x, int y) {
        if (i > x || j > y)return 0;
        if (i == x && j ==y)return 1;

        return dfs(i+1,j,x,y) + dfs(i,j+1,x,y);

    }

}
