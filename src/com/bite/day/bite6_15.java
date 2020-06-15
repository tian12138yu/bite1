package com.bite.day;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/15 10:50
 */

public class bite6_15 {
    public static void main(String[] args) {
//        int x= 5;
//        int y = 10;
//        boolean a =  x > 10 && y <20 || x < 10 && y >20;
//        System.out.println(a);
        int i = 0;
        for (out('A');out('B')&&(i<2);out('C')){
            i++;
            out('D');
        }

    }
    /**
     * aaaaaaaaaa
     * a        a
     * a        a
     * a        a
     * aaaaaaaaaa
     * @param args
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int i = Integer.parseInt(s1[0]);
        char c = s1[1].charAt(0);
        for (int j = 0; j < i; j++) {
            if (j % 2 == 0 && j != i-1) {
                System.out.print(c);
                if (j == 0 || j == i-2){
                    for (int k = 1; k < i; k++) {
                        System.out.print(c);
                    }
                }else {
                    for (int k = 1; k < i-1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(c);
                }
                System.out.println();
            }else {
                if (j == i-2){
                    for (int k = 0; k < i; k++) {
                        System.out.print(c);
                    }
                }
            }
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(AddLongInteger(s1, s2));
        }


    }

    public static String AddLongInteger(String addend,String augend){
        int len1 = addend.length();
        int len2 = augend.length();
        int len = Math.min(len1,len2);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int pre = 0;
        while (i <= len){
            int x = addend.charAt(len1 - i) + augend.charAt(len2 - i) - 48*2 + pre;
            pre = x / 10;
            x = x % 10;
            sb.append(x);
            i++;
        }
        String s ;
        if (len1 > len2){
            s = addend;
            len = len1;
        }else {
            s = augend;
            len = len2;
        }
        while (i <= len){
            int x = s.charAt(len - i)- 48 + pre;
            pre = x /10;
            x = x %10;
            sb.append(x);
            i++;
        }
        if (pre == 1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    static boolean out (char c){
        System.out.println(c);
        return true;
    }

    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();

            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();
            int lenS = Math.max(lenA, lenB);

            // arrS保存最终生成的结果
            int[] arrA = new int[lenS];
            int[] arrB = new int[lenS];
            int[] arrS = new int[lenS + 1];

            for (int i = 0; i < lenA; i++) {
                arrA[i] = a.charAt(lenA - 1 - i) - '0';
            }

            for (int i = 0; i < lenB; i++) {
                arrB[i] = b.charAt(lenB - 1 - i) - '0';
            }

            for (int i = 0; i < lenS; i++) {
                int sum = arrS[i] + arrA[i] + arrB[i];
                int flag = sum /10;
                arrS[i]  = sum % 10;
                arrS[i+1] += flag;
            }

            for (int i = arrS[lenS] == 0?1:0; i < lenS + 1; i++) {
                System.out.print(arrS[lenS - i]);
            }

            System.out.println();

        }

        scan.close();
    }


















//    abstract class x{
//        abstract void say();
//    }
//    class y extends x{
//        public y(){
//            System.out.println("444");
//        }
//
//        @Override
//        void say() {
//
//        }
//    }
}
