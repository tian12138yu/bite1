package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/9/27 11:23
 */

public class bite9_27 {

    public static void main(String[] args) {
        int[] a = {5,4,8,6,2,7};
        System.out.println(quickFindKth(a, 0, a.length - 1, 3));
    }

    public static int quickFindKth(int[] a,int left,int right,int k) {
        if (left >= right)return -1;
        int low = left;
        int high = right;
        int temp = a[left];

        while (low < high) {
            while (low < high && a[high] > temp) {
                high--;
            }
            a[low] = a[high];

            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = temp;
        if (low == k-1)
            return a[low];
        else {
            if (low > k) {
                return quickFindKth(a,left,low - 1,k);
            }else {
                return quickFindKth(a,low + 1,right,k);
            }
        }
    }


}
