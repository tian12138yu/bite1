package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/9/2 19:05
 */

public class bite9_2 {

    public static void main(String[] args) {
        System.out.println(dfs(4));
    }

    private static int dfs(int i) {
        if (i == 0)return 1;
        if (i == 1)return 3;
        return dfs(i -1) * 2 + dfs(i -2) * 2;
    }
}
