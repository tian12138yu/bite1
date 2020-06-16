package com.bite.day;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/16 14:25
 */

public class bite6_16 {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s1.length; i++) {
            int x = Integer.parseInt(s1[i]);
            if (x != 0){
                sb.append(i);
                s1[i] = String.valueOf(x-1);
                break;
            }
        }

        for (int i = 0; i < s1.length; i++) {
            int x = Integer.parseInt(s1[i]);
            for (int j = 0; j < x; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            scanner.nextLine();
            getString(input);
        }
        scanner.close();
    }

    public static void getString(int input) {
        int curNum = input * (input - 1) + 1;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < input; i++) {
            if (i == input - 1) {
                sb.append(curNum);
            }
            else {
                sb.append(curNum + "+");
            }
            curNum += 2;
        }
        System.out.println(sb.toString());
    }
}
