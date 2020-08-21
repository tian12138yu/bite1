package com.bite;

/**
 * @Author tjy
 * @Date 2020/6/19 16:02
 */

public class TreeNode implements Comparable<TreeNode>{
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    @Override
    public int compareTo(TreeNode o) {
        return this.val - o.val;
    }
}
