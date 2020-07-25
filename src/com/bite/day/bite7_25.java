package com.bite.day;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/7/25 9:59
 */

public class bite7_25 {

    /**
     * {1,2,3},{4,5,6},{7,8,9},{10,11,12}
     * {1,2},{3,4}
     * {4,46,89},{28,66,99},{26,21,71}
     *
     * {98,30,17},{38,96,90},{17,0,50},{44,12,67},{12,79,43},{43,63,40},{19,93,48}
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = {{98,30,17},{38,96,90},{17,0,50},{44,12,67},{12,79,43},{43,63,40},{19,93,48}};
        int[] ints = clockwisePrint(array, 7, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 找出数组最大值，作为最大值，然后找到头尾两个数的最小值相减即可。
     * 因为从两端往里面找，要是小，减的值确实大，但不能选，因为要两边的最大值，
     * 那要是大，就更不选了，因为减的值小了，所以只要找到两端的最小值即可。
     * @param A
     * @param n
     * @return
     */
    public int findMaxGap(int[] A, int n) {
        // write code here
        int max = A[0],min;
        for (int i = 1; i < n; i++) {
            max = Math.max(max,A[i]);
        }
        min = Math.min(A[0],A[n-1]);
        return max - min;
    }

    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int lbegin = 0;
        int lend = m -1;
        int rbegin = 1;
        int rend =  n - 2;
        int[] res = new int[n*m];
        int x= 0;
        while (lbegin <= lend && rbegin <= rend){
            for (int i = lbegin; i <= lend; i++) {
                res[x] = mat[rbegin-1][i];
                x++;
            }

            for (int i = rbegin; i <= rend; i++) {
                res[x] =mat[i][lend];
                x++;
            }

            for (int i = lend; i >= lbegin; i--) {
                res[x] = mat[rend+1][i];
                x++;
            }

            if (lbegin == lend)return res;
            for (int i = rend; i >= rbegin; i--) {
                res[x] =mat[i][lbegin];
                x++;
            }

            lbegin++;
            lend--;
            rbegin++;
            rend--;
        }
        for (int i = lbegin; i <= lend; i++) {
            res[x] = mat[rbegin-1][i];
            x++;
        }
        if (rbegin - rend  == 2)return res;
        for (int i = lend; i >= lbegin; i--) {
            res[x] = mat[rend+1][i];
            x++;
        }


        return res;
    }
}
