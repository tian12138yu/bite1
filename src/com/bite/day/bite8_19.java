package com.bite.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Author tjy
 * @Date 2020/8/19 11:08
 */

public class bite8_19 {

    public int countSubstrings1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dfs(i,j,s))
                    res++;

            }

        }
        return res;
    }

    private boolean dfs(int i, int j, String s) {
        if (i == j)return true;
        while (i < j){
            if (s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }


    int res;
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            countHuiwen(i,i,s);
            countHuiwen(i,i+1,s);

        }
        return res;
    }

    private void countHuiwen(int low, int high, String s) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            res++;
            low--;
            high++;
        }

    }

    static List<String> al = new ArrayList<>();
    public static List<String> ambiguousCoordinates(String S) {
        if (S.length() == 0 || S.equals(" "))return new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            insert(i,S);
        }
        return al;
    }

    private static void insert(int i, String s) {
        String low = s.substring(0, i);
        String high = s.substring(i);
        if ((Integer.parseInt(low) == 0 && low.length() > 1) ||
                (Integer.parseInt(high) == 0 && high.length() > 1))
            return;
        String s1 = "";
        String s2 = "";
        for (int j = 0; j < low.length(); j++) {
            s1 += low.charAt(j);
            StringBuilder sb1;
            if (Integer.parseInt(s1) == 0 && s1.length() ==1)continue;
            if (low.length() == 1 && low.charAt(0) == '0'){
                sb1 = new StringBuilder("0");
            }else {
                sb1 = new StringBuilder(low);
                sb1.insert(j+1,'.');
            }
            for (int k = 0; k < high.length(); k++) {
                if (k == high.length()-1)continue;
                s2 += high.charAt(k);
                StringBuilder sb2;
                if (Integer.parseInt(s2) == 0 && s2.length() ==1)continue;
                if (high.length() == 1 && high.charAt(0) == '0'){
                    sb2 = new StringBuilder("0");
                }else {
                    sb2 = new StringBuilder(high);
                    sb2.insert(k+1,'.');
                }

                String res = sb1.toString() + ", "+sb2.toString();
                al.add(res);
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(ambiguousCoordinates("123"));
        new CountDownLatch(6);
        CyclicBarrier dashuaibi = new CyclicBarrier(8, () -> {
            System.out.println("dashuaibi");
        });
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    dashuaibi.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Semaphore semaphore = new Semaphore(5);
        semaphore.acquire();semaphore.release();
        Collections.synchronizedList(new ArrayList<>());
    }
}
