package com.bite.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/18 13:16
 */

public class bite6_18 {

    public abstract class a{

    }

    public static void main1(String[] args) {
        int s = 5;
            //5     7     7      5
        s = (s++)+(++s)+(s--)+(--s);
        System.out.println(s);
    }

    abstract  interface fafa{

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> als = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> al = new ArrayList<>(2*n1 + 2);
            al.add(n1);
            for (int j = 0; j < 2 * n1; j++) {
                al.add(sc.nextInt());
            }
            al.add(k);
            als.add(al);
        }

        for (List<Integer> a: als) {
            int k = a.get(a.size() - 1);
            a.remove(a.size()-1);
            int size = a.size();
            for (int i = 0; i < k; i++) {
                a = swap(a);
            }

            for (int i = 1; i < size-1; i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.println(a.get(size-1));
        }


    }

    private static List<Integer> swap(List<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>(a.size());
        res.add(a.get(0));
        res.add(a.get(1));
        int n = a.get(0);
        for (int i = 1; i < n; i++) {
            res.add(a.get(i+n));
            res.add(a.get(i+1));
        }
        res.add(a.get(a.size()-1));
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n == 0)return;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (map.containsKey(x)){
                    map.put(x ,map.get(x)+1);
                }else {
                    map.put(x,1);
                }
            }
            int res = sc.nextInt();
            if (map.get(res) == null){
                System.out.println(0);
            }else {
                System.out.println(map.get(res));
            }
            map.clear();

        }
    }
}
