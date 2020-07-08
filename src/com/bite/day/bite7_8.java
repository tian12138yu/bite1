package com.bite.day;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/8 10:53
 */

public class bite7_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            HashMap<Character, Character> isWin = new HashMap<>();
            isWin.put('B','C');
            isWin.put('C','J');
            isWin.put('J','B');
            int awin = 0;
            int bWin = 0;
            int ping = 0;
            for (int i = 0; i < n; i++) {
                char a = sc.next().charAt(0);
                char b = sc.next().charAt(0);
                if (a == b)ping++;
                else {
                    if (isWin.get(a) != b){
                        bWin++;
                        if (map2.containsKey(b)){
                            map2.put(b,map2.get(b)+1);
                        }else {
                            map2.put(b,1);
                        }
                    }else {
                        if (map1.containsKey(a)){
                            map1.put(a,map1.get(a)+1);
                        }else {
                            map1.put(a,1);
                        }
                        awin++;
                    }
                }
            }

            System.out.println(awin + " " + ping + " " + bWin);
            System.out.println(bWin + " " + ping + " " + awin);
            char max = ' ';
            int max1 = 0;
            if (map1.size() == 0){
                System.out.print('B');
            }else {
                for (Map.Entry<Character,Integer> entry : map1.entrySet()){
                    Integer value = entry.getValue();
                    if (value > max1){
                        max = entry.getKey();
                        max1 = value;
                    }else if (value == max1){
                        max = (char) Math.min(max,entry.getKey());
                        max1 = value;
                    }
                }
                System.out.print(max + " ");
            }
            if (map2.size() == 0){
                System.out.println('B');
            }else {
                max = ' ';
                max1 = 0;
                for (Map.Entry<Character,Integer> entry : map2.entrySet()){
                    Integer value = entry.getValue();
                    if (value > max1){
                        max = entry.getKey();
                        max1 = value;
                    }else if (value == max1){
                        max = (char) Math.min(max,entry.getKey());
                        max1 = value;
                    }
                }
                System.out.println(max);
            }


        }
    }

//    static class num implements Comparable<num>{
//        char gesture;
//        int nums;
//
//        public num(char gesture, int nums) {
//            this.gesture = gesture;
//            this.nums = nums;
//        }
//
//        public int getNums() {
//            return nums;
//        }
//
//        public void setNums(int nums) {
//            this.nums = nums;
//        }
//
//        @Override
//        public int compareTo(num o) {
//            if (o.nums == this.nums){
//                return this.gesture - o.gesture;
//            }else {
//                return this.nums - o.nums;
//            }
//        }
//    }

    public int countWays(int n) {
        // write code here
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = ((dp[i-1] + dp[i-2]) % 1000000007 + dp[i-3])%1000000007;
        }
        return dp[n-1];
    }
}
