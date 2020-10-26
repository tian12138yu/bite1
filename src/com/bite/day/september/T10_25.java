package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/10/25 17:17
 */


/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 */
public class T10_25 {


    public static void main(String[] args) {

    }


    public int longestMountain(int[] A) {
        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i+1]) {
                int low = i - 1;
                int high = i + 1;
                int temp = 3;

                while (low > 0 && A[low] > A[low - 1]) {
                    low--;
                    temp++;
                }

                while (high < A.length - 1 && A[high] > A[high + 1]) {
                    high++;
                    temp++;
                }

                if (temp > max)
                    max= temp;
            }
        }
        return max;
    }






















}
