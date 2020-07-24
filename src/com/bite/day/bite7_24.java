package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/24 10:21
 */

public class bite7_24 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = br.readLine().split(" ");
            int[] array = new int[s1.length];
            for (int i = 0; i < s1.length; i++) {
                array[i] = Integer.parseInt(s1[i]);
            }
            String s2 = br.readLine();
            int k = Integer.parseInt(s2.charAt(0)+"");
            int d = Integer.parseInt(s2.charAt(2)+"");
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            int x;
            if (d > s1.length){
                x = s1.length;
            }else {
                x = d;
            }
            int max = 1,min = 1;
            for (int i = 0; i < x; i++) {
                if (array[i] > 0){
                    max *= array[i];
                    min *= array[i];
                }else {
                    max = min * array[i];
                    min = max * array[i];
                }
                pq.offer(array[i]);
                pq1.offer(array[i]);
            }
            if (x != s1.length){
                for (int i = x; i < s1.length; i++) {
                    if (array[i] > 0){
                        max /= array[i-x];
                    }
                    pq.remove(array[i-x]);
                    pq.offer(array[i]);
                    max = Math.max(max,Max(pq,k));
                }
            }
            System.out.println(max);
        }
    }

    private static int Max(PriorityQueue<Integer> pq, int k) {
        int max = 1;
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = pq.poll();
            max *= a[i];
        }
        for (int i = 0; i < k; i++) {
            pq.offer(a[i]);
        }
        return max;
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line.trim());
            line = br.readLine();
            int[] nums = new int[n];
            String[] s = line.trim().split(" ");
            for(int i=0;i<n;i++){
                nums[i] = Integer.parseInt(s[i]);  //a[i]表示学生的能力值
            }
            line = br.readLine();
            String[] s1 = line.trim().split(" ");
            int k = Integer.parseInt(s1[0]);  //选取k个学生
            int d = Integer.parseInt(s1[1]);  //编号之差不超过d
            long[][] max = new long[k][n];
            long[][] min = new long[k][n];
            for(int i=0;i<k;i++){
                for(int j=0;j<n;j++){
                    max[i][j] = 1;
                    min[i][j] = 1;
                    if(i==0){
                        min[i][j] = nums[j];
                        max[i][j] = nums[j];
                    }
                }
            }
            for(int i=1;i<k;i++){
                for(int j=0;j<n;j++){
                    for(int m=1;m<=d;m++){
                        if(j-m >= 0){
                            if(nums[j] > 0){
                                min[i][j] = Math.min(min[i][j], min[i-1][j-m] * nums[j]);
                                max[i][j] = Math.max(max[i][j], max[i-1][j-m] * nums[j]);
                            }else{
                                min[i][j] = Math.min(min[i][j], max[i-1][j-m] * nums[j]);
                                max[i][j] = Math.max(max[i][j], min[i-1][j-m] * nums[j]);
                            }
                        }
                    }
                }
            }
            long res = 0;
            for(int i=0;i<n;i++){
                if(i>=k-1){
                    res = Math.max(res, max[k-1][i]);
                }
            }
            System.out.println(res);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            Person[] people = new Person[n];
            for (int i = 0; i < n; i++) {
                String[] s1 = br.readLine().split(" ");
                people[i] = new Person(Integer.parseInt(s1[1]),Integer.parseInt(s1[2]));
            }
            Arrays.sort(people);
            System.out.println(Arrays.toString(people));
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            dp[0] = 1;
            for (int i = 0; i < dp.length; ++i) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (people[i].high < people[j].high
                            || (people[i].hight == people[j].hight && people[i].high == people[j].high)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }

    static class Person implements Comparable<Person>
    {
        int high;
        int hight;
        public Person(int high,int hight){
            this.high = high;
            this.hight = hight;
        }

        @Override
        public int compareTo(Person o) {
            if (o.hight != this.hight){
                return o.hight - this.hight;
            }else {
                return o.high - this.high;
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "high=" + high +
                    ", hight=" + hight +
                    '}';
        }
    }

    static class People {
        int height;
        int weight;

        public People(int weight, int height) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "People{" +
                    "height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main4(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            People[] array = new People[n];
            for (int i = 0; i < n; ++i) {
                int index = scan.nextInt();
                array[index - 1] = new People(scan.nextInt(), scan.nextInt());
            }

            Arrays.sort(array, new Comparator<People>() {
                public int compare(People p1, People p2) {
                    int result = Integer.compare(p1.height, p2.height);
                    if (result != 0)
                        return result;
                    else
                        return Integer.compare(p1.weight, p2.weight);
                }
            });

            System.out.println(Arrays.toString(array));

            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; ++i) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (array[i].weight > array[j].weight
                            || (array[i].weight == array[j].weight && array[i].height == array[j].height)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}
