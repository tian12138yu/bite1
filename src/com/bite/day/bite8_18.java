package com.bite.day;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author tjy
 * @Date 2020/8/18 10:31
 */

public class bite8_18 {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0 || num == null || size > num.length)return new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        ArrayList<Integer> res = new ArrayList<>();
        int low;
        int high = size;
        for (int i = 0; i < size; i++) {
            pq.offer(num[i]);
        }
        res.add(pq.peek());
        for (low = 0; high < num.length; low++,high++) {
            pq.remove(num[low]);
            pq.offer(num[high]);
            res.add(pq.peek());
        }
        return res;
    }

    public static int cutRope(int n) {
        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        if(n%3==0){
            return (int)Math.pow(3,n/3);
        }else if(n%3==1){
            return 4*(int)Math.pow(3,n/3-1);
        }else {
            return 2*(int)Math.pow(3,n/3);
        }
    }
}
