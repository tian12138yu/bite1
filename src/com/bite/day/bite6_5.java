package com.bite.day;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/6/5 13:48
 */

public class bite6_5 {

    static int count = 0;
    static int[] arr;
    static int n ;
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        while (s.hasNext())
        {
            n = s.nextInt();
            arr = new int[n+1];
            for (int i = 1; i <= n; ++i)
            {
                arr[i] = s.nextInt();
            }
            beibao(40, n);
            System.out.println(count);
        }

    }

    /**
     * @param s 表示背包剩下的容量大小
     * @param n 表示剩下的东西数量
     */
    public static void beibao (int s, int n)
    {

//       如果背包容量刚好等于零，说明刚好装满
        if (s == 0)
        {
            count ++;
        }
//        背包容量小于零或者容量大于零但是东西数量小于零，则不能刚好装满
        if (s<=0 || (s>0 && n<0))
        {
            return;
        }
//        从最后一个开始装
        beibao(s-arr[n], n-1);
//        如果最后一个和其他是都值完了，从倒数第二个开始
        beibao(s, n-1);
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty())return -1;
        return stack2.pop();
    }
}
