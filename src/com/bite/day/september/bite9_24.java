package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author tjy
 * @Date 2020/9/24 16:07
 */

public class bite9_24 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ( (s = br.readLine()) != null) {
            StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && chars[i] != '_') {
                    sb.append(chars[i]);
                    i++;
                }
                sb.reverse();
                res.append(sb.toString());
                if (i < chars.length) {
                    res.append("_");
                }
            }
            System.out.println(res.toString());
        }
    }

    public static void main2(String[] args) throws IOException {
        // code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }

            for (Map.Entry<Character,Integer> entry: map.entrySet()) {
                if (entry.getValue() == 1)
                    System.out.print(entry.getKey());
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int A = s.charAt(0) - '0';
            int B = s.charAt(2) - '0';
            ArrayList<Integer> al1 = new ArrayList<>();
            ArrayList<Integer> al2 = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                String s1 = br.readLine();
                int x = s1.charAt(0) - '0';
                int y = s1.charAt(2) - '0';
                for (int j = 0; j < y; j++) {
                    al1.add(x);
                }
            }

            for (int i = 0; i < B; i++) {
                String s1 = br.readLine();
                int x = s1.charAt(0) - '0';
                int y = s1.charAt(2) - '0';
                for (int j = 0; j < y; j++) {
                    al2.add(x);
                }
            }

            Collections.sort(al1);
            Collections.sort(al2);
            int i = 0;int j = 0;
            int res = 0;
            for (; i < al1.size();) {
                if (al1.get(i) > al2.get(j)) {
                    res++;
                    j++;
                }else {
                    i++;
                    j = 0;
                }

                if (j == al2.size() && i < al1.size()){
                    i++;
                    j = 0;
                }

            }

            System.out.println(res);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int m = s.charAt(0) - '0';
            int n = s.charAt(2) - '0';
            System.out.println(dfs(m,n));
        }
    }

    private static int dfs(int m, int n) {

        if (n == 1 || m == 0)return 1;
        else if (n > m) return dfs(m,m);
        else return dfs(m,n-1) + dfs(m - n,n);
    }
}


