package com.bite.day.september;

import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/9/14 10:32
 */

public class bite9_14 {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     */

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur!= null) {
                s.push(cur);
                cur = cur.left;
            }

            TreeNode pop = s.pop();
            res.add(pop.val);
            cur = pop.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(inorderTraversal(root));
        new StringBuilder();
    }
}
