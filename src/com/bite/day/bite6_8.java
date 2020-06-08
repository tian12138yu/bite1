package com.bite.day;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/8 14:47
 */

public class bite6_8 {
    /**
     * 二位网格放蛋糕，每个位置的两个格子为半径的圆上不能放第二个
     * 求最多可以放几个蛋糕。
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] arrays = new int[w][h];
        dfs(arrays,0,0,0);
    }

    private static void dfs(int[][] arrays, int i,int j,int count) {

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int evenICount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        int oddICount = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
        int ans = m / 4 * (evenICount + oddICount) * 2;
        if(m % 4 > 0) ans += evenICount;
        if(m % 4 > 1) ans += evenICount;
        if(m % 4 > 2) ans += oddICount;
        System.out.println(ans);
    }

    /**
     * 两个数a,b的最小公倍数是a*b/gcd(a,b)
     * 由于两个数的乘积等于这两个数的最大公约数与最小公倍数的积，即（a，b）× [a，b] = a × b
     */

    public static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }
    /**
     * 求最大公约数：辗转相除法
     * 1\. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
     * 2\. 互换：置 a←b，b←r，并返回第一步
     */
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(lcm(a, b));
    }
}
