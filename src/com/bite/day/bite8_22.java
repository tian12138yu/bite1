package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author tjy
 * @Date 2020/8/22 15:25
 */

public class bite8_22 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            int res = 0;
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                if (s1.length() > 10)
                    continue;
                else {
                    if (isChar(s1))
                        res++;
                }
            }

            System.out.println(res);

        }
    }

    private static boolean isChar(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            if (!Character.isLetter(s1.charAt(i)))
                return false;
        }
        return true;
    }

    /**
     * 给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），现在要对排列进行M次操作，每次操作为以下两种中一种：
     *
     * ①将排列的第1个数移到末尾；
     *
     * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
     *
     * 求经过这M次操作后得到的排列。
     */

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                al.add(i);
            }

            String[] s2 = br.readLine().split(" ");
            for (int i = 0; i < s2.length; i++) {
                if (Integer.parseInt(s2[i]) == 1)
                    al.add(al.remove(0));
                else {
                    swap(al);
                }
            }
            for (int i = 0; i < al.size()-1; i++) {
                System.out.print(al.get(i)+ " ");
            }
            System.out.println(al.get(n-1));
        }
    }

    private static void swap(ArrayList<Integer> al) {
        for (int i = 0; i < al.size(); i += 2) {
            int temp = al.get(i);
            al.set(i,al.get(i+1));
            al.set(i+1,temp);
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                deque.offer(i);
            }

            String[] s2 = br.readLine().split(" ");
            for (int i = 0; i < s2.length; i++) {
                if (Integer.parseInt(s2[i]) == 1)
                   deque.addLast(deque.poll());
                else {
                    swap(deque);
                }
            }
            while (deque.size() > 1){
                System.out.print(deque.poll() + " ");
            }
            System.out.println(deque.getLast());
        }
    }

    private static void swap(Deque<Integer> deque) {
        int x = deque.size() >>> 1;
        while (x > 0){
            int one = deque.poll();
            int two = deque.poll();
            deque.addLast(two);
            deque.addLast(one);
            x--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            Node head = new Node(1);
            Node tail = new Node(n);
            tail.next = head;
            Node pre = head;
            for (int i = 2; i < n; i++) {
                Node node = new Node(i);
                pre.next = node;
                pre = node;
            }
            pre.next = tail;

            String[] s2 = br.readLine().split(" ");
            for (int i = 0; i < s2.length; i++) {
                if (Integer.parseInt(s2[i]) == 1) {
                    tail = head;
                    head = head.next;
                }
                else {
                    head = swap(head,tail,n);
                    tail = tail.next;
                    tail.next = head;
                }
            }

            while (head != tail){
                System.out.print(head + " ");
                head = head.next;
            }
            System.out.println(tail);
        }
    }

    private static Node swap(Node head, Node tail,int n) {
        n = n >>> 1;
        Node res = head.next;
        Node pre = tail;
        Node cur = head;
        Node next = head.next;
        Node next1 = next.next;
        while (n > 0){
            pre.next = next;
            next.next = cur;
            cur.next = next1;

            pre = cur;
            cur = next1;
            next = cur.next;
            next1 = next.next;
            n--;
        }

        return res;
    }

}
class Node{
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val +"";
    }
}