package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/10 19:05
 */

public class Demo {


    /**
     * 4
     * 0 1 4 6
     */
    public static void main1(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int[] array = new int[m];
            for (int i = 0; i < m; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            int x = array[0];
            int y =array[array.length - 1];
            int mid = (x + y) >>> 1;
            int mid1 = mid + 1;
            int mid2 = mid -1;
            int sum = 0;
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] > mid)
                    sum += (array[i] - mid);
                else
                    sum += (mid - array[i]);
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > mid)
                    sum1 += (array[i] - mid);
                else
                    sum1 += (mid - array[i]);
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > mid)
                    sum2 += (array[i] - mid);
                else
                    sum2 += (mid - array[i]);
            }
            int min = Math.min(sum, Math.min(sum1, sum2));
            System.out.println(min);

        }
    }



    public static String frequencySort (String s) {
        // write code here

        if (s.startsWith(" ") && s.endsWith(" "))return s;
        s = s.trim();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i-1]){
                sb.append(" ");
            }
            sb.append(chars[i]);
        }

        String[] s1 = sb.toString().split(" ");
        Arrays.sort(s1, (o1, o2) -> o2.length() - o1.length());
        sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            sb.append(s1[i]);
        }
        return sb.toString();
    }

    public static String frequencySort2 (String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        return "";
    }


    public static int uniquePaths (int[][] arr) {
        // write code here
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        int i = 0;
        int j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0)continue;
                if (j == 0)dp[i][0] = dp[i-1][0] + arr[i][j];
                else if (i == 0)dp[0][j] = dp[0][j-1] + arr[i][j];
                else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
                }
            }
        }

        return dp[i-1][j-1];

    }


    public static void main(String[] args) {
//        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(uniquePaths(a));
        System.out.println(frequencySort("trewrasbnjkvahodias"));
    }




}
