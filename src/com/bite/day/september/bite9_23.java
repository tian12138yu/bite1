package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/23 16:28
 */

public class bite9_23 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String ss = "0123456789abcdefghijklmnopqrstuvwxyz";
        while ((s = br.readLine()) != null) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 36; i++) {
                map.put(ss.charAt(i),i);
            }

            long deciaml = 0;
            int power = s.length() - 1;
            char[] c = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(c[i]) || Character.isLetter(c[i])){
                    int x = map.get(c[i]);
                    deciaml = (long) (deciaml + x * Math.pow(36,power));
                    power--;
                }else {
                    System.out.println(0);
                    continue;
                }

            }
            System.out.println(deciaml);
        }
    }

    public static int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here
        int c = 0;
        int r = 0;
        int h = 0;
        int[] res = new int[requirements.length];
        for (int i = 0; i < increase.length; i++) {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            List<Integer> al = isTrue(c,r,h,requirements);
            if (al.size() == 0)continue;
            for (int j = 0; j < al.size(); j++) {
                if (res[al.get(j)] == 0)
                    res[al.get(j)] = i+1;
            }

        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0)
                res[i] = -1;
        }
        return res;
    }

    private static List<Integer> isTrue(int c, int r, int h, int[][] requirements) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < requirements.length; i++) {
            if (c >= requirements[i][0] && r >= requirements[i][1] && h >= requirements[i][2])
                al.add(i);
        }

        return al;

    }

    public static void main(String[] args) {
        int[][] a = {{2,8,4},{2,5,0},{10,9,8}};
        int[][] aa = {{2,11,3},{15,10,7},{9,17,12},{8,1,14}};
        System.out.println(Arrays.toString(getTriggerTime(a, aa)));
    }
}
