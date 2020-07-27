package com.bite.day;

/**
 * @Author tjy
 * @Date 2020/7/27 10:18
 */

public class bite7_27 {

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        boolean b ;
        for (int i = 1; i < amount+1; i++){
            b = false;
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++){
                if (i >= coins[j] && dp[i - coins[j]]!= Integer.MAX_VALUE){
                    b =true;
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]);
                }
            }
            if (b){
                dp[i] += 1;
            }

        }
        if (dp[amount] == Integer.MAX_VALUE)return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 1));
    }

    /**
     * 将一个字符串变为另一个字符串的最少步数。
     *
     * 定义dp[m][n]，代表从第一个字符串的前n个字符变到第二个字符的M个，最少需要多少步。
     *
     * 状态方程为：判断当前这两个字符是否相等，相等表名不需要操作，直接就是dp[m-1][n-1]的值。
     * 如果不相等就判断给第一个加一个，第二个加一个，两个都直接替换，这三个中哪个走的步数最少。
     *    MIN(dp[m-1][n]     dp[m][n-1]     dp[m-1][n-1])
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 1; i < m+1; i++) {
            dp[i][0] = i;
            for (int j = 1; j < n+1; j++) {
                dp[0][j] = j;
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[m+1][n+1];
    }
}
