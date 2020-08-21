package com.bite.day;

import com.bite.TreeNode;

import java.util.PriorityQueue;

/**
 * @Author tjy
 * @Date 2020/8/21 20:06
 */

/**
 * 构建一个哈夫曼树。
 * 哈夫曼树又称最优子树，他的所有叶子节点的权重乘上到达叶子节点的边长的总和是最小的。
 * 就是权重越大的离根节点越近。
 */
public class bite8_21 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        PriorityQueue<TreeNode> treeNodes = new PriorityQueue<>();//把书的节点存放在优先队列中，按照节点的权重
        CreatTree(treeNodes);
    }

    private static TreeNode CreatTree(PriorityQueue<TreeNode> pq) {
        TreeNode root;
        while (pq.size() != 1) {
            TreeNode node1 = pq.poll();
            TreeNode node2 = pq.poll();
            TreeNode parent = new TreeNode(node1.val + node2.val);
            parent.left = node1;
            parent.right = node2;
            pq.offer(parent);
        }

        return pq.poll();
    }
    /**
     * 哈夫曼树编码压缩
     *
     * 我们按照字母出现的次数作为树节点的权重来构建一个哈夫曼树，然后从跟节点开始，往左走就记为0，往右走记为1，
     * 我们就可以按照给出的字符串顺序来生成一个只有01的编码。
     * 当我们解码的，按照这个编码左右进行遍历哈夫曼树，当到达叶子节点时，就表明是一个字符，将叶子节点的字符记录即可。
     *
     *
     * 一般编码都是使用三位来表示，而哈夫曼树可以最少使用一位来表示，可以大大减少文件的大小。
     *
     *
     */

}

