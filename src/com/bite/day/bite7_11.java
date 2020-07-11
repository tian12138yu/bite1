package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author tjy
 * @Date 2020/7/11 12:42
 */

public class bite7_11 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z'){
                    if (map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                    }else {
                        map.put(c,1);
                    }
                }
            }
            char c = 'A';
            for (; c <= 'Z'; c++) {
                Integer integer = map.get(c);
                if (integer == null){
                    integer = 0;
                }
                System.out.println(c + ":" + integer);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            System.out.println(Integer.decode(s));
        }
    }
}
