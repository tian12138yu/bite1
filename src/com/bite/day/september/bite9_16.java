package com.bite.day.september;

import com.bite.TreeNode;

/**
 * @Author tjy
 * @Date 2020/9/16 19:10
 */

public class bite9_16 {

    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        if (root == null)
            return;

        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;

        swap(root.left);
        swap(root.right);
    }


}
