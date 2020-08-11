package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/8/10 19:05
 */

public class Demo {


    /**
     * 4
     * 0 1 4 6
     */
    public static void main(String[] args) throws IOException {
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
}
