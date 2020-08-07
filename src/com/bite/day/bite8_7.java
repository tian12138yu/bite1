package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/8/7 11:18
 */

public class bite8_7 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= " ";
        while ((s = br.readLine()) != null){
            String[] s2 = s.split(" ");

            int x = Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);
            int[][] a = new int[x][y];
            for (int i = 0; i < x; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < y; j++) {
                    a[i][j] = Integer.parseInt(s1[j]);
                }
            }

            /**
             * 动态规划计算出最小的路径。
             */
            int[][] dp = new int[x+1][y+1];
            dp[x][y-1] = 1;
            dp[y-1][x] = 1;
            for (int i = x - 1; i >= 0; i--) {
                for (int j = y - 1; j >= 0; j--) {
                    dp[i][j] = Math.max(1,Math.min(dp[i+1][j],dp[i][j+1]) - a[i][j]);
                }
            }
            System.out.println(dp[0][0]);

        }

    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int m = Integer.parseInt(strs[0]), n = Integer.parseInt(strs[1]);
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(strs[j]);
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
