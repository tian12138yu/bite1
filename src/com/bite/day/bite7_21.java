package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/21 10:20
 */

public class bite7_21 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split("_");
            StringBuilder sb = new StringBuilder(s1[0]);
            for (int i = 1; i < s1.length; i++) {
                char c = s1[i].charAt(0);
                c = (char) (c -32);
                sb.append(c);
                sb.append(s1[i].substring(1));
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                StringBuilder sb1 = null;
                if (Character.isLetter(chars[i])){
                    sb1 = new StringBuilder();
                    while (i < s.length() && Character.isLetter(chars[i])){
                        sb1.append(s.charAt(i++));
                    }
                }

                if (sb1 == null)continue;
                if (sb.length() != 0){
                    sb.insert(0," ");
                }
                sb.insert(0,sb1.toString());
            }
            System.out.println(sb.toString());
        }
    }
}
