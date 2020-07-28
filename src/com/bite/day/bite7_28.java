package com.bite.day;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Author tjy
 * @Date 2020/7/28 10:18
 */

public class bite7_28 {

    public static void main1(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] choose = new int[nums.length+1];
        choose[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length+1; i++) {
            if (choose[i -1] <= 0)choose[i] = nums[i-1];
            else choose[i] = choose[i-1] + nums[i-1];
            max = Math.max(choose[i],max);
        }
        return choose[nums.length];


    }

    /**
     * 给定一个整数数组 nums ，你可以对它进行一些操作。
     *
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
     *
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     *
     * 示例 1:
     *
     * 输入: nums = [3, 4, 2]
     * 输出: 6
     * 解释:
     * 删除 4 来获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] choose = new int[nums.length+1];
        int[] noChoose = new int[nums.length+1];
        choose[0] = 0;
        noChoose[0] = 0;
        int j = 1;
        boolean b ;
        for (int i = 0; i < nums.length;) {
            b = false;
            if (i > 0 && nums[i] == nums[i-1]+1){
                b = true;
            }
            int x = nums[i];i++;
            int sum = x;
            while (i < nums.length && x == nums[i]){
                i++;
                sum += x;
            }

            if (b){
                choose[j] = noChoose[j-1] + sum;

            }else {
                choose[j] = Math.max(choose[j - 1] + sum, noChoose[j - 1] + sum);
            }
            noChoose[j] = Math.max(choose[j-1],noChoose[j-1]);
            j++;
        }
        return Math.max(choose[j-1],noChoose[j-1]);
    }

    public int DeleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i ++) {
            trans[nums[i]] += nums[i];
        }

        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + trans[i]);
        }

        return dp[dp.length - 1];
    }
    static int[] col ;
    static int[] left ;
    static int[] right ;
    static List<List<String>> res;
    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<String> al = new ArrayList<>();
        col = new int[2*n -1];
        left = new int[2*n -1];
        right = new int[2*n -1];
        dfs(0,al,n);
        return res;
    }

    private static void dfs(int row, List<String> al,int n) {
        if (row == n){
            res.add(new ArrayList<>(al));
            return;
        }
        String s = "";
        for (int i = 0; i < n; i++) {
            if (col[i] == 0 && left[row + i] == 0 &&
                    right[i - row + n - 1] == 0){
                col[i] += 1;
                left[row + i] += 1;
                right[i - row + n - 1] += 1;
                int x = i+1;
                StringBuilder sb = new StringBuilder(s);
                sb.append("Q");
                while (x < n){
                    sb.append(".");
                    x++;
                }
                al.add(sb.toString());
                dfs(row+1,al,n);
                al.remove(al.size()-1);
                col[i] -= 1;
                left[row + i] -= 1;
                right[i - row + n - 1] -= 1;

            }
            s += ".";
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(5);
        for (List<String> al: lists){
            System.out.println(al);
        }
    }
    /**
     * [["Q....","..Q..","....Q",".Q...","...Q."]
     * ["Q....","...Q.",".Q...","....Q","..Q.."],
     * [".Q...","...Q.","Q....","..Q..","....Q"],
     * [".Q...","....Q","..Q..","Q....","...Q."],
     * ["..Q..","Q....","...Q.",".Q...","....Q"],
     * ["..Q..","....Q",".Q...","...Q.","Q...."],
     * ["...Q.","Q....","..Q..","....Q",".Q..."],
     * ["...Q.",".Q...","....Q","..Q..","Q...."],
     * ["....Q",".Q...","...Q.","Q....","..Q.."],
     * ["....Q","..Q..","Q....","...Q.",".Q..."]]
     */

    /**
     * [["Q....","..Q..","....Q",".Q...","...Q."],
     * ["Q....","...Q.",".Q...","....Q","..Q.."],
     * ["Q....","....Q",".Q...","...Q.","Q...."],
     * ["Q....","....Q","..Q..","Q....","...Q."],
     * [".Q...","...Q.","Q....","..Q..","....Q"],
     * [".Q...","....Q","..Q..","Q....","...Q."],
     * ["..Q..","Q....","...Q.",".Q...","....Q"],
     * ["..Q..","....Q",".Q...","...Q.","Q...."],
     * ["...Q.","Q....","..Q..","....Q",".Q..."],
     * ["...Q.","Q....","....Q",".Q...","...Q."],
     * ["...Q.","Q....","....Q","..Q..","Q...."],
     * ["...Q.",".Q...","....Q","Q....","...Q."],
     * ["...Q.",".Q...","....Q","..Q..","Q...."],
     * ["....Q",".Q...","...Q.","Q....","..Q.."],
     * ["....Q","..Q..","Q....","...Q.",".Q..."]]
     */



}
