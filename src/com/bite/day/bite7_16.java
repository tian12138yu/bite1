package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/16 9:01
 */

public class bite7_16 {

    public static void mai1n(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String s1 = br.readLine();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s1.length(); i++) {
                set.add(s1.charAt(i));
            }

            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))){
                    System.out.print(s.charAt(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            for (int i = s1.length -1; i > 0; i--) {
                System.out.print(s1[i]);
                System.out.print(" ");
            }
            System.out.print(s1[0]);

        }

    }
}
