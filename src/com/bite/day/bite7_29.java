package com.bite.day;

/**
 * @Author tjy
 * @Date 2020/7/29 10:28
 */

public class bite7_29 {
    public static void main(String[] args) {
        System.out.println(waysToChange2(10));
    }

    public static int waysToChange2(int n) {
        int[] dp = new int[n+1];
        int[] array = {1,5,10,25};
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == array[i])dp[j] = (dp[j] + 1)%1000000007;
                else if (j > array[i]){
                    dp[j] = (dp[j] + dp[j-array[i]])%1000000007;
                }
            }
        }
        return dp[n] ;
    }

    public static int waysToChange1(int n) {
        int dp[] = new int[n+1];
        int[] tokens = {1,5,10,25};
        int mod = 1000000007;
        for(int i=0;i<4;i++){
            for(int j=1;j<=n;j++){
                if(tokens[i]==j){               //硬币刚好等于当前面额
                    dp[j] = (dp[j] + 1)%mod;
                }else if(tokens[i]<j){         //硬币小于当前面额
                    dp[j] = (dp[j] + dp[j-tokens[i]])%mod;
                }                               //硬币大于当前面额，dp[j] = dp[j]，省略了
            }
        }
        return dp[n];
    }
}
