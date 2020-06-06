package com.bite.day;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/6 13:13
 */
//class a{
//    public a(){
//        System.out.println("a");
//    }
//    static {
//        System.out.println("aa");
//    }
//}

public class bite6_6 {

//    public bite6_6(){
//        System.out.println("b");
//    }
//    static {
//        System.out.println("bb");
//    }
//
//    public static void main(String[] args) {
//        new bite6_6();
//
//    }

    public static void main1(String... args) {
        Scanner sc = new Scanner(System.in);
        int a_b = sc.nextInt();
        int b_c = sc.nextInt();
        int ab = sc.nextInt();
        int bc = sc.nextInt();
        int a,b,c;
        a = (a_b + ab) >>> 1;
        b = (b_c + bc) >>> 1;
        c = bc - b;
        if ((a_b + ab)%2 == 0 && (b_c + bc)%2 == 0 && (a+b==ab)){
            System.out.println(a +" " + b +" " + c);
        }else {
            System.out.println("No");
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        while (sc.hasNext()){
            al.add(sc.nextInt());
        }
        Collections.sort(al);
        int count = 1;
        for (int i = 1; i < al.size(); i++) {
            if (al.get(i).equals(al.get(i - 1))){
                count++;
            }
            else count = 1;
            if (count >= al.size()>>>1) {
                System.out.println(al.get(i));
                return;
            }
        }
    }
}
