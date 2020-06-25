package com.bite.day;

import com.bite.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/25 11:41
 */

public class bite6_25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String pri = sc.nextLine();
            String want = sc.nextLine();
            ArrayList<Character> set1 = new ArrayList<>();
            ArrayList<Character> set2 = new ArrayList<>();
            for (int i = 0; i < pri.length(); i++) {
                set1.add(pri.charAt(i));
            }

            for (int i = 0; i < want.length(); i++) {
                char c = want.charAt(i);
                if (set1.contains(c)){
                    set1.remove(set1.indexOf(c));
                }
                else {
                    set2.add(c);
                }
            }
            if (!set2.isEmpty()){
                System.out.println("No" + " "+ set2.size());
            }else {
                System.out.println("Yes" + " " + set1.size());
            }
        }
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int temp = 0;
        ListNode root = null;
        ListNode pre = new ListNode(-1);
        while (a != null && b != null){
            int x = a.val + b.val + temp;
            temp = x / 10;
            x = x % 10;
            ListNode node = new ListNode(x);
            if (root == null){
                root = node;
            }
            pre.next = node;
            pre = node;
            a = a.next;
            b = b.next;

        }

        while (a != null){
            int x = a.val + temp;
            x = x % 10;
            temp = x / 10;
            ListNode node = new ListNode(x);
            pre.next = node;
            pre = node;
            a = a.next;
        }

        while (b != null){
            int x = b.val + temp;
            x = x % 10;
            temp = x / 10;
            ListNode node = new ListNode(x);
            pre.next = node;
            pre = node;
            b = b.next;
        }

        if (temp != 0){
            pre.next = new ListNode(1);
        }

        return root;
    }
}
