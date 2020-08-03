package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/3 10:15
 */

public class bite8_3 {

    public static void main1(String[] args) {
        int[] x = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(x, 4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || k <= 0)return new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            pq.offer(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (input[i] < pq.peek()){
                pq.poll();
                pq.offer(input[i]);
            }
        }
        ArrayList<Integer> al = new ArrayList<>(pq);
        Collections.sort(al);
        return al;

    }


    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = " ";
        while ((s = br.readLine()) != null){
            char[] chars = s.toCharArray();
            StringBuilder res = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])){
                    sb = new StringBuilder();
                    while (i < chars.length && Character.isDigit(chars[i])){
                        sb.append(chars[i]);
                        i++;
                    }
                }
                else {
                    if (sb.length() > res.length()){
                        res = sb;
                    }
                }
            }
            if (sb.length() > res.length()){
                res = sb;
            }
            System.out.println(res.toString());
        }
    }

    /**
     *     3 5
     *     2 4 2
     *     1 3
     *     3 5
     *     3 7
     *     5 9
     *     1 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = " ";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s2 = br.readLine();
            String[] s3 = s2.split(" ");
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
               al.add(Integer.parseInt(s3[i]));
            }
            Collections.sort(al);
            List<Customer> customers = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String s4 = br.readLine();
                String[] s5 = s4.split(" ");
                customers.add(new Customer(Integer.parseInt(s5[0]),Integer.parseInt(s5[1])));
            }

            int res = 0;
            Collections.sort(customers);
//            System.out.println(customers);
            for (int i = 0; i < m; i++) {
                Customer poll = customers.get(0);
                customers.remove(0);
                int left = 0;
                int right = al.size()-1;
                int mid = 0;
                while (left <= right){
                    mid = (left + right) >>> 1;
                    if (al.get(mid) >= poll.nums)right = mid-1;
                    else left = mid+1;
                }
                if (left < al.size()){
                    res += poll.price;
                    al.remove(left);
                }
            }

            System.out.println(res);
        }
    }

    static class Customer implements Comparable<Customer>{
        int nums;
        int price;

        public Customer(int nums, int price) {
            this.nums = nums;
            this.price = price;
        }


        @Override
        public int compareTo(Customer o) {
            if (o.price != this.price){
                return o.price - this.price;
            }else {
                return this.nums - o.nums;
            }
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "nums=" + nums +
                    ", price=" + price +
                    '}';
        }
    }


}
