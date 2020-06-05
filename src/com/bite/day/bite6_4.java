package com.bite.day;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/4 13:30
 */

public class bite6_4 {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = dfs(n,0);
        if (n == 0)res = 0;
        System.out.println(res);
    }

    private static int dfs(int n,int res) {
        if (n == 0)return res;
        if (n < 0)return -1;
        int x = dfs(n - 6,res + 1);
        int y = dfs(n - 8,res + 1);
        if (x == y && x == -1)return -1;
        if (x == -1 || y == -1)
        return x == -1 ? y : x;
        return Math.min(x,y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        ArrayList<Character> al = new ArrayList<>();
        for (char c : s2.toCharArray()) {
            al.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!al.contains(c)){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
