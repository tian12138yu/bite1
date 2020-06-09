package com.bite.day;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/9 13:28
 */

public class bite6_9 {

    public static void main1(String[] args) {
        double x = 3.0;
        int y = 5;
        x /= --y;
        System.out.println(x);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n > 1000)n =999;
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(i);
            }
            int i = 2;
            while (al.size() > 1){
                al.remove(i);
                i = (i + 2) % al.size();
            }
            System.out.println(al.get(0));
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        while (sc.hasNext()){
            al.add(sc.nextInt());
        }
        int n = al.get(al.size() - 1);
        al.remove(al.size() - 1);
        //大顶堆，容量11
        PriorityQueue<Integer> pq = new PriorityQueue<>(n,(i1, i2) -> i2-i1);
        for (int i = 0; i < n; i++) {
            pq.offer(al.get(i));
        }
        for (int i = n; i < al.size(); i++) {
            int x = al.get(i);
            if (pq.peek() > x){
               pq.poll();
               pq.offer(x);
            }
        }
        Stack<Integer> s = new Stack<>();
        while (!pq.isEmpty()){
            s.push(pq.poll());
        }
        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

}
