package com.bite.day;

import com.bite.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tjy
 * @Date 2020/8/12 10:01
 */

public class bite8_12 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null)return null;
            ListNode root1 = pHead1;
            ListNode root2 = pHead2;
            while (root1 != root2){
                if (root1 == null){
                    root1 = pHead2;
                    continue;
                }
                if (root2 == null){
                    root2 = pHead1;
                    continue;
                }
                root1 = root1.next;
                root2 = root2.next;
            }

        return root1;
    }

    public int GetNumberOfK(int [] array , int k) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low < high){
            mid = (low + high) >>> 1;
            if (array[mid] == k){
                break;
            }
            else if (array[mid] > k){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        int count = 0;
        int left = mid-1;
        while (left >= 0 && array[left] == k){
            left--;
            count++;
        }
        while (mid < array.length && array[mid] == k){
            mid++;
            count++;
        }
        return count;
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int temp = 0;
        int mid;
        if (sum > 3)mid = (sum >>> 1) +1;
        else mid = sum;
        for (int i = 1; i < mid; i++) {
            queue.offer(i);
            temp += i;
            while (temp > sum){
                int poll = queue.poll();
                temp -= poll;

            }
            if (temp == sum){
                res.add(new ArrayList<>(queue));
            }
        }
        return res;
    }

    public String LeftRotateString(String str,int n) {
        if (n == 0 || str.length() == 0)return str;
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2 + s1;
    }



}
