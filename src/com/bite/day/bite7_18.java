package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/18 9:39
 */

public class bite7_18 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] s1 = s.split(" ");
            int year = Integer.parseInt(s1[0]);
            int mon = Integer.parseInt(s1[1]);
            int days = Integer.parseInt(s1[2]);
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                day[1] = 29;
            }
            if(year <= 0 ||mon <= 0 || mon > 12 || days<= 0 || days > day[mon - 1]){
                System.out.println(-1);
                continue;
            }
            int res = 0;
            for (int i = 0; i < mon-1; i++) {
                res += day[i];
            }
            res += days;
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String s1 = lock(s);
            String s2 = unlock(br.readLine());
            System.out.println(s1);
            System.out.println(s2);
        }
    }


    private static String unlock(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)){
                if (Character.isLowerCase(c)){
                    if (c == 'a'){
                        sb.append('Z');
                    }else {
                        sb.append((char)(c - 33));
                    }

                }else {
                    if (c == 'A'){
                        sb.append('z');
                    }else {
                        sb.append((char)(c + 31));
                    }
                }
            }else {
                if (c == '0'){
                    sb.append('9');
                }else {
                    sb.append(c - '0'-1);
                }

            }
        }
        return sb.toString();
    }

    private static String lock(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)){
                if (Character.isLowerCase(c)){
                    if (c == 'z'){
                        sb.append('A');
                    }else {
                        sb.append((char)(c - 31));
                    }

                }else {
                    if (c == 'Z'){
                        sb.append('a');
                    }else {
                        sb.append((char)(c + 33));
                    }

                }
            }else {
                sb.append(((c - '0')+1) % 10);
            }
        }
        return sb.toString();
    }
}
