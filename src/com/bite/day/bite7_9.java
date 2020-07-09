package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @Author tjy
 * @Date 2020/7/9 9:20
 */

public class bite7_9 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (( s = br.readLine()) != null){
            String s1 = br.readLine();
            s1 = s1.toUpperCase();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s1.length(); i++) {
                set.add(s1.charAt(i));
            }
            s = s.toUpperCase();
            for (int i = 0; i < s.length(); i++) {

                if (set.add(s.charAt(i))){
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (( s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            float[] floats = new float[6];
            for (int i = 0; i < s1.length; i++) {
                floats[i] = Float.parseFloat(s1[i]);
            }
            double r;
            r = (Math.pow(Math.abs(floats[3] - floats[0]),2) +
                                Math.pow(Math.abs(floats[4] - floats[1]),2) +
                                    Math.pow(Math.abs(floats[5] - floats[2]),2));

            r = Math.sqrt(r);

            double res = 4*Math.acos(-1)*Math.pow(r,3) / 3;
            System.out.printf("%.3f",r);
            System.out.print(" ");
            System.out.printf("%.3f",res);
        }
    }
}
