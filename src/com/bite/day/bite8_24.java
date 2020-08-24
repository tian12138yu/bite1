package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/8/24 10:15
 */

public class bite8_24 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            int i =1;
            sb.append(Character.toUpperCase((s.charAt(0))));
            for (; i < s.length(); i++) {
                if (s.charAt(i) == 'n'){
                    System.out.println(sb.toString());
                    sb = new StringBuilder("N");
                }
                else
                    sb.append(s.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int[][] arr = new int[n][m+1];
            for (int i = 0; i < n; i++) {
                String[] s2 = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j+1] = Integer.parseInt(s2[j]);
                }
            }

            int[][][] dp = new int[n][m+1][m+1];
            for (int i = 0; i < m; i++) {
                dp[0][i][i] = arr[0][i];
            }

            for (int i = 1; i < n; i++) {
                for (int k = 1; k <= m; k++) {
                    for (int j = 1; j <= m; j++) {
                        if (k > j){
                            dp[i][j][k] = Math.max(dp[i - 1][j][k - j] + arr[i][j], dp[i - 1][j][k]);
                        }else {
                            dp[i][j][k] = Math.max(arr[i][j],dp[i - 1][j][k]);
                        }

                    }
                }
            }

            int max = 0;
            for (int i = 1; i <= m; i++) {
                max = Math.max(max, dp[n - 1][i][m]);
            }
            System.out.println(max);
        }
    }
}
