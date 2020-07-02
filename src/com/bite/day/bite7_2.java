package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/2 13:25
 */

public class bite7_2 {
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int num = Integer.parseInt(s);
            int square = num * num ;
            boolean b = String.valueOf(square).endsWith(s);
            if (b){
                System.out.println("Yes!");
            }else
            System.out.println("No!");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            if (s.length() <= 8){
                System.out.println("NG");
                continue;
            }
            int[] contains = new int[4];
            boolean b = true;
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 2){
                    String substring = s.substring(i, i + 3);
                    if (s.substring(i+1).contains(substring)){
                        b = false;
                    }
                }
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    contains[0] = 1;
                    continue;
                }
                else if (c >= 'a' && c <= 'z') {
                    contains[1] = 1;
                    continue;
                }
                else if (c >= 'A' &&c <= 'Z') {
                    contains[2] = 1;
                    continue;
                }else {
                    contains[3] = 1;
                    continue;
                }
            }
            int res = 0;
            for (int i = 0; i < 4; i++) {
                res += contains[i];
            }

            if (res >= 3 && b){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }

        }
    }
}
