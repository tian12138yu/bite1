package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/8/20 19:57
 */

public class bite8_20 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (( s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            if (n == 0 || m == 0) {
                System.out.println(0);
                break;
            }
            String[] fwq = br.readLine().split(" ");
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(Integer.parseInt(fwq[i]));
            }
            Customer[] customers = new Customer[m];
            for (int i = 0; i < m; i++) {
                String[] s2 = br.readLine().split(" ");
                customers[i] = new Customer(Integer.parseInt(s2[0]),Integer.parseInt(s2[1]));
            }
            Arrays.sort(customers);
//            System.out.println(Arrays.toString(customers));
            int res = 0;
            for (int i = 0; i < customers.length; i++) {
                if (al.contains(customers[i].size)){
                    al.remove(al.indexOf(customers[i].size));
                    res += customers[i].money;
                }
            }
            System.out.println(res);
        }
    }

    static class Customer implements Comparable<Customer>{
        int size;
        int money;

        public Customer(int size, int money) {
            this.size = size;
            this.money = money;
        }

        @Override
        public int compareTo(Customer o) {
            return o.money - this.money;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "size=" + size +
                    ", money=" + money +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = "";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                String[] s2 = sc.nextLine().split(" ");
//                String[] s1 = br.readLine().split(" ");
                tasks[i] = new Task(Integer.parseInt(s2[0]),Integer.parseInt(s2[1]),Integer.parseInt(s2[2]));
            }
            Arrays.sort(tasks);
            int[] dp = new int[n];
            dp[0] = tasks[0].money;
            for (int i = 1; i < n; i++) {
                dp[i] = tasks[i].money;
                for (int j = i - 1; j >= 0; j--) {
                    if (tasks[i].start > tasks[j].end){
                        dp[i] = Math.max(dp[j] + tasks[i].money,dp[i]);
                    }
                }
            }

            System.out.println(dp[n-1]);
        }
    }

    static class Task implements Comparable<Task>{
        int start;
        int end;
        int money;

        public Task(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }


        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }
}
