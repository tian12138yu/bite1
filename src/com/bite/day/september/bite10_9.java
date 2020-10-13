package com.bite.day.september;

import com.bite.ListNode;

import java.util.List;

/**
 * @Author tjy
 * @Date 2020/10/9 9:43
 */

public class bite10_9 {

    public static void main(String[] args) {
        System.out.println(get(1));
    }

    public static int get(int i){
        try{
            ++i;
            System.out.println(i);
            return i ++;
        }finally {
            ++ i;
            System.out.println(i);
        }

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode low = head;

        while (low != null && fast != null && fast.next!= null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }



}
