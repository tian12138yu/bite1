package com.bite.day;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/20 16:42
 */

public class bite6_20 {

    public static void main1(String[] args) {
        Integer a1 = 5;
        Integer a6 = 5;
        int a2 = 5;
        Integer a3 = Integer.valueOf(5);//等于new Integer（）；
        Integer a4 = new Integer(5);
        Integer a5 = new Integer(5);
        System.out.println(a3 == a4);
        System.out.println(a1 == a3);
        System.out.println(a1 == a4);
        System.out.println(a1 == a6);
        System.out.println(a1 == a2);
        System.out.println(a2 == a4);
        System.out.println(a5 == a4);
        System.out.println(a2 == a3);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        Queue<Character> queue = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            queue.offer(c);
            if (c == 'G' || c == 'C'){
                max++;
            }
        }
        Queue<Character> queue1 = new LinkedList<>(queue);
        int count = max;
        for (int i = n; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            Character poll = queue.poll();
            if (poll == 'G' || poll == 'C'){
                count--;
            }
            queue.offer(c);
            if (c == 'G' || c == 'C'){
                count++;
            }

            if (count > max){
                max = count;
                queue1 = new LinkedList<>(queue);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(queue1.poll());
        }

    }

    public static void main(String[] args) {
        int num1 = 30*10;
        int num2 = 1;
        int res = 1;
        for (int i = 0; i < 29; i++) {
            num2 = num2*2;
            res += num2;
        }
        System.out.println(num1+" "+res);
    }
}
