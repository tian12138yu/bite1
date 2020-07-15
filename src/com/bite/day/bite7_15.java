package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/15 13:13
 */

public class bite7_15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int i = 0;
            int j = s.length() -1;
            boolean x = false;
            while (i < j){
                boolean a =false;
                boolean b = false;
                if (s.charAt(i) != s.charAt(j)){
                    StringBuilder sb = new StringBuilder(s);
                    a = ishuiwen(sb.insert(j+1,s.charAt(i)).toString());
                    sb = new StringBuilder(s);
                    b = ishuiwen(sb.insert(i,s.charAt(j)).toString());
                }
                if (a || b) {
                    System.out.println("Yes");
                    x = true;
                    break;
                }
                i++;
                j--;
            }
            if (!x){
                System.out.println("No");
            }

        }
    }

    private static boolean ishuiwen(String s) {
        int i = 0;
        int j = s.length() -1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int x = 0;int y = n - 1;
        int[] res = new int[n * n];
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            int a = x,b = y;
            while (a < n && b < n){
                res[count] = arr[x][y];
                a++;b++;
                count++;
            }
            if (y == 0){
                x++;
            }else {
                y--;
            }
        }
        return res;

    }
}
