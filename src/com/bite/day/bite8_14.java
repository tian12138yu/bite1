package com.bite.day;

import com.bite.ListNode;

/**
 * @Author tjy
 * @Date 2020/8/14 11:34
 */

public class bite8_14 {


    /**
     * 5 + 7
     * 0101
     * 0111
     * ^ : 0010   & : 0101
     * 0010
     * 1010
     *^ : 1000  & 0010
     * 1000
     * 0100
     * ^ :1100 &0000
     *
     */
    public static int Add(int num1,int num2) {

        int a = num1 ^ num2;
        int b = num1 & num2;//获取进位位
        int c = b << 1;

        if(b != 0) {
            int end = Add(a, c);
            a = end;
        }

        return a;

    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null)return null;
        ListNode low = pHead.next;
        ListNode fast = pHead.next.next;
        while (low != fast){
            if (low == null || fast == null)return null;
            low = low.next;
            fast = fast.next.next;
        }

        int count = 1;
        low = low.next;
        while (low != fast){
            low = low.next;
            count++;
        }

        low = pHead;
        fast = pHead;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }

        while (low != fast){
            low = low.next;
            fast = fast.next;
        }

        return low;

    }






}
