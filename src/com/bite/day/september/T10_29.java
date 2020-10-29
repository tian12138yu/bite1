package com.bite.day.september;

/**
 * @Author tjy
 * @Date 2020/10/29 12:19
 */


import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 */
public class T10_29 {
    static List<String> al = new ArrayList<>();
    static String s = "";
    public static int sumNumbers(TreeNode root) {
        dfs(root);
        int res = 0;
        for (String s : al) {
            res += Integer.parseInt(s);
        }
        return res;
    }

    public static boolean dfs(TreeNode node) {
        if (node == null) return true;
        s += node.val;
        if (dfs(node.left) & dfs(node.right)) {
            al.add(s);
        }
        s = s.substring(0,s.length()-1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }





























}
