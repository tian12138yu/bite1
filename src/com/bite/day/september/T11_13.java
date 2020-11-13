package com.bite.day.september;

import com.bite.ListNode;

/**
 * @Author tjy
 * @Date 2020/11/13 13:07
 */

public class T11_13 {

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     *
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     */

    public static ListNode oddEvenList(ListNode head) {
        ListNode root = head;
        ListNode next = head.next;
        ListNode last = head.next;

        while (last != null) {
            if (last.next != null) {
                head.next = last.next;
                head = head.next;
            }else {
                break;
            }

            last.next = head.next;
            last = last.next;

        }
        if (last != null)
            last.next = null;
        head.next = next;

        return root;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = null;
        ListNode listNode = oddEvenList(l);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
