package com.bite.day;


/**
 * @Author tjy
 * @Date 2020/7/10 11:06
 */

public class bite7_10 {
    public static void main(String[] args) {
        int x = 1;
        int count = 0;
        for (int i = 0; i < 30; i++) {
            count += x;
            x *= 2;
        }
        System.out.println(10*30 + " " + count);
    }

    public int calculateMax(int[] prices) {
        if(prices.length<2) return 0;
        int len =  prices.length;
        int k = 2;
        int[] dp = new int[2*k+1];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 2;i<2*k+1;++i){
            dp[i] = Integer.MIN_VALUE;
        }
        int max = 0;
        for(int i=1;i<len;++i){
            dp[0] = 0;
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
            for(int j = 2;j<2*k+1;++j){
                dp[j] = Math.max(dp[j],j%2==0? dp[j-1]+prices[i]:dp[j-1]-prices[i]);
                if (j%2==0){
                    max = Math.max(max,dp[j]);
                }
            }
        }
        return max;
    }
}
