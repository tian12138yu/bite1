package com.bite.day;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/10 13:29
 */

public class bite6_10 {

    public static void a() {
        System.out.println("aaa");
    }

    public static void main1(String[] args) {
        ((bite6_10)null).a();

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal res = new BigDecimal(1);
        BigDecimal n1 = new BigDecimal(n);
        BigDecimal n2 = new BigDecimal(1);
        if (n == 0)res = new BigDecimal(0);
        else {
            while (!n1.toString().equals("1")){
                res = res.multiply(n1);
                n1 = n1.subtract(n2);
            }
        }
        String s = String.valueOf(res);
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '0')count++;
            else break;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = String.valueOf(n);
        System.out.println(new StringBuilder(s).reverse().toString());
    }
}
