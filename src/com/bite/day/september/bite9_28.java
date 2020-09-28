package com.bite.day.september;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/9/28 12:06
 */

public class bite9_28 {

    public Node1 connect(Node1 root) {
        Queue<Node1> s = new LinkedList<>();
        s.offer(root);
        while (!s.isEmpty()) {
            int size = s.size();
            Node1 pre = s.poll();
            for (int i = 1; i < size; i++) {
                Node1 pop = s.poll();
                pre.next = pop;
                if (pop.left != null)
                    s.offer(pop.left);
                if (pop.right != null)
                    s.offer(pop.right);
            }
        }
//        return root;



        if (root == null) {
            return null;
        }
        // 借助队列实现层次遍历
        LinkedList<Node1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node1 node = queue.remove();
                if (size > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }

    public int jioucha(int[] a) {
        int j = 0;
        int o = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0){
                o += a[i];
            }else {
                j += a[i];
            }
        }

        return j - o;

    }

    public int findTwoth(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                res = a[i] + i + map.get(a[i]);
                return res;
            }else {
                map.put(a[i],i);
            }
        }
        return res;
    }

    public int findNum(int[] a,int num) {
        for (int i = 0; i < a.length; i++) {
            String s = a[i]+ "";
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp += (s.charAt(j) - '0');
            }

            if (temp == num) {
                return i;
            }
        }
        return -1;
    }


}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
