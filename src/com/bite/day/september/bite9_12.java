package com.bite.day.september;

import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author tjy
 * @Date 2020/9/12 9:44
 */

public class bite9_12 {

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)return new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        long sum = 0;
        double count = 0;
        nodes.offer(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                sum += poll.val;
                count++;

                if (poll .left != null)
                    nodes.offer(poll.left);
                if (poll.right != null)
                    nodes.offer(poll.right);
            }

            res.add(sum / count);
            sum = 0;
            count = 0;
        }

        return res;
    }

















}
