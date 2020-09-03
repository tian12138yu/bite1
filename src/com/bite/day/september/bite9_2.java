package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tjy
 * @Date 2020/9/2 19:05
 */

public class bite9_2 {

    public static void main1(String[] args) {
        System.out.println(dfs(4));
    }

    private static int dfs(int i) {
        if (i == 0)return 1;
        if (i == 1)return 3;
        return dfs(i -1) * 2 + dfs(i -2) * 2;
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s1.length; i++) {
                if (s1[i] .equals("0")){
                    sb.append(s1[i]);
                }else {
                    sb.insert(0,s1[i]);
                }
            }
            System.out.println(-1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
//        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            for (int d = 0; d < n; d++) {
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);//奶牛数量
                int y = Integer.parseInt(s1[1]);//特性数量
//            List<List<Integer>> als = new ArrayList<>();
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < y; i++) {
//                List<Integer> al = new ArrayList<>();
                    int z = Integer.parseInt(br.readLine());
                    for (int j = 0; j < z; j++) {
                        String[] s2 = br.readLine().split(" ");
                        int a = Integer.parseInt(s2[0]);
                        int b = Integer.parseInt(s2[1]);
                        for (int k = a; k <= b; k++) {
//                        al.add(k);
                            if (map.containsKey(k)){
                                map.put(k,map.get(k) + 1);
                            }else {
                                map.put(k,1);
                            }
                        }
                    }
//                als.add(al);
                }
                List<Integer> res = new ArrayList<>();
                for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                    if (entry.getValue() == y)
                        res.add(entry.getKey());
                }

                System.out.println(res.size());
                for (int i = 0; i < res.size() - 1; i++) {
                    System.out.print(res.get(i)+" ");
                }
                System.out.println(res.get(res.size() - 1));
            }


        }

//    }

}
