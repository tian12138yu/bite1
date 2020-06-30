package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @Author tjy
 * @Date 2020/6/30 13:43
 */

public class bite6_30 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null ){
            int x = Integer.parseInt(s);
            x = (int) Math.pow(x,2);
            String s1 = String.valueOf(x);
            int res1 = 0;
            int res2 = 0;
            for (int i = 0; i < s.length(); i++) {
                res1 += s.charAt(i) - 48;
            }
            for (int i = 0; i < s1.length(); i++) {
                res2 += s1.charAt(i) - 48;
            }

            System.out.println(res1 + " " + res2);
        }
    }

    /**
     * 4
     * A B C D
     * 8
     * A B C D E F G H
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null ){
            int n  = Integer.parseInt(s);
            String s1 = br.readLine();
            String[] s2 = s1.split(" ");
            HashMap<String, Integer> map = new HashMap<>(s2.length);
            ArrayList<String> al = new ArrayList<>();
            for (int i = 0; i < s2.length; i++) {
                map.put(s2[i],0);
                al.add(s2[i]);
            }
            String s3 = br.readLine();
            int num = Integer.parseInt(s3);
            String s4 = br.readLine();
            String[] s5 = s4.split(" ");
            int count = 0;
            for (int i = 0; i < s5.length; i++) {
                if (map.containsKey(s5[i])){
                    map.put(s5[i],map.get(s5[i])+1);
                }else {
                    count++;
                }
            }

            for (String s6 : al){

                System.out.println(s6 + " "+ ":" + " " +  map.get(s6));
            }
            System.out.println("Invalid" + " "+ ":" + " " + count);
        }
    }
    /**
     * A : 1
     * B : 1
     * C : 1
     * D : 1
     * Invalid : 4
     *
     *
     */
}
