package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author tjy
 * @Date 2020/7/20 10:25
 */

public class bite7_20 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            TreeSet<String> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s1.length(); j++) {
                    int index = symbol.indexOf(s1.charAt(j));
                    if (index != -1)sb.append(number.charAt(index));
                    if (sb.length() == 3)sb.append("-");
                }
//                sb.toString();
                set.add(sb.toString());
            }

            for (String ss : set){
                System.out.println(ss);
            }
            System.out.println();
        }
    }
    
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            dfs(1,m,n);
            for(ArrayList<Integer> l : res) {
                int i = 0;
                for(; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    private static void dfs(int i, int m, int n) {
        if (m == 0)res.add(new ArrayList<>(al));
        else {
            for (int j = i; j <= n && j <= m; j++) {
                al.add(j);
                dfs(j+1,m - j,n);
                al.remove(al.size()-1);
            }
        }
    }
}
