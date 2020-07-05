package com.bite.day;



import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/5 12:15
 */

public class bite7_3 {
    /**
     * 5 15
       5 5 10 2 3
     * @param args
     *
     */
    static int n;
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n+1];
        int sum = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(dp(array,sum));
        sc.close();
    }

    public static long dp(int[] a,int sum)
    {
        long dp[][] = new long[n+1][sum+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=sum; j++) {
                if(j >= a[i])
                    dp[i][j] = dp[i-1][j-a[i]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }

        }
        return dp[n][sum];
    }

    public static float count(int n) {
        //这个函数用来得到有多少种可能，每个人拿不到自己的名字，
        //也就是得到分子
        if(n==1){
            //n=1的时候返回0
            return 0;
        }
        if(n==2){
            //n=2的时候返回1
            return 1;
        }else{
            //否则就递归。
            return (n-1)*(count(n-1)+count(n-2));
        }
    }
    //下面的函数用来求阶乘，也是递归，最后得到分母
    public static float probability(int n){
        if(n==1){
            //0的阶乘等于1，不用多说吧
            return 1;
        }else{
            //阶乘表示，进行递归
            return n*probability(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //将得到的分子分母进行相除，就可以得到概率了。
            float result = (count(n) / probability(n)) * 100;
            System.out.println(String.format("%.2f", result) + "%");
        }
    }


}
