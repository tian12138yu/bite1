package com.bite.day.september;

import com.bite.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/10/20 20:14
 */

public class T10_20 {

    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     *
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     *
     */

    public static void reorderList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        ListNode mid = low;
        while (low != null) {
            s.push(low);
            low = low.next;
        }

        ListNode cur = head;
        ListNode next;

        while (!s.isEmpty()) {
            next = cur.next;
            ListNode pop = s.pop();
            cur.next = pop;
            if (s.isEmpty())
                pop.next = null;
            else
                pop.next = next;
            cur = next;
        }


    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reorderList(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
