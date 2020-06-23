package com.bite.day;

import com.bite.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/6/23 13:42
 */

public class bite6_23 {
    /**
     * 找出数组中出现次数超过总数一半的数。
     * @param gifts
     * @param n
     * @return
     * 1.先将数组中的元素排序，由于目标元素的数量超过数组长度的一半，故排序后数组的中间元素
     * 2.将一个目标元素和一个其它元素进行抵消，由于目标元素的数量大于其它元素的数量，故经过多次抵消后，剩下的元素即目标元素。
     */
    public static int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(gifts[i])){
                int i1 = map.get(gifts[i]);
                if ((i1 + 1)> gifts.length/2){
                    return gifts[i];
                }
                map.put(gifts[i],i1+1);
            }else {
                map.put(gifts[i],1);
            }

        }
        return 0;
    }

    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode head = new ListNode(-1);
        ListNode mid = new ListNode(-1);
        ListNode root = head;
        ListNode count = mid;
        while (pHead != null){
            if (pHead.val >= x){
                mid.next = pHead;
                mid = mid.next;
            }
            else {
                head.next = pHead;
                head = head.next;
            }
            pHead = pHead.next;
        }
        mid.next = null;
        head.next = count.next;
        return root.next;
    }

    public static void main1(String[] args) {
        int[] a = {1,2,3,2,2};
        System.out.println(getValue(a, 5));
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode partition = partition(listNode1, 3);
        while (partition != null){
            System.out.print(partition.val+ "->");
            partition = partition.next;
        }

    }
}
