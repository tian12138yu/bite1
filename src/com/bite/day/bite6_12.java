package com.bite.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/12 15:22
 */

public class bite6_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 48;
            if (hashMap.containsKey(x)){
                hashMap.put(x,hashMap.get(x)+1);
            }else {
                hashMap.put(x,1);
                al.add(x);
            }
        }
        Collections.sort(al);
        for (int x: al) {
            System.out.println(x+":"+hashMap.get(x));
        }
    }

    public int[] multiply(int[] A) {

    }
}
