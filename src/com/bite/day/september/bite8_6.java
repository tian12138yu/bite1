package com.bite.day.september;

import com.bite.TreeNode;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/9/6 19:14
 */

public class bite8_6 {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> lists = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                al.add(poll.val);
                if (poll.left != null)
                    queue.offer(poll.left);

                if (poll.right != null)
                    queue.offer(poll.right);
            }
            s.push(al);
        }

        while (!s.isEmpty()){
            lists.add(s.pop());
        }
        return lists;
    }
}
