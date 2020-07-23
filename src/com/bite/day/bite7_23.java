package com.bite.day;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/7/23 10:15
 */

public class bite7_23 {

    public static void main(String[] args) {
        int[] a = {2,1,4,5,2,9,7};
//        System.out.println(MoreThanHalfNum_Solution(a));

        System.out.println(maxProfit(2, a));
    }

    /**
     * [4,2,1,4,2,4]
     * 1 2 2 4 4 4
     *
     * 1,2,3,2,4,2,5,2,3
     * 1 2 2 2 2 3 3 4 5
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1)return array[0];
        if (array.length == 2)return 0;
        double len = array.length;
        Arrays.sort(array);
        int temp = (int)len >>> 1;
        int low = temp - 1;
        int high = temp + 1;
        while (high < array.length && array[temp] == array[high]){
            high++;
        }

        while (low >= 0 && array[low] == array[temp]){
            low--;
        }
        double half = len / 2;
        if (high - low -1 <= half)return 0;
        return array[temp];
    }

    public static int maxProfit(int k, int[] prices) {
        if (k == 0)return 0;
        if (prices.length == 0)return 0;
        int[][][] dp = new int[prices.length][k+1][2];
        //将第一天数组初始化
        for (int i = k; i >= 0; i--) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][k][0] = 0;//表示以前的天数都没有进行买卖操作，从当前i天开始操作。
            dp[i][k][1] = -prices[i];
            for (int j = k - 1; j >= 0; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j+1][0] - prices[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            max = Math.max(dp[prices.length-1][i][0],max);
        }
        return max;
    }

    public static int maxProfit1(int k, int[] prices) {
        if (prices==null||prices.length==0||k==0)return 0;
        if(k>=prices.length/2)return greedy(prices);
        int[][][] dp=new int[prices.length][k+1][2];
        for (int i=0;i<prices.length;i++){
            for (int j=1;j<=k;j++){
                if (i==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[0];
                }else {
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i=1;i<k+1;i++){
            max=Math.max(max,dp[prices.length-1][i][0]);
        }
        return max;
    }
    public static int greedy(int[] p){
        int max = 0;
        for(int i = 1;i < p.length;i++){
            if(p[i] > p[i-1])
                max += p[i] - p[i-1];
        }
        return max;
    }
}
