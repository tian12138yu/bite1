package com.bite.day;

import com.bite.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tjy
 * @Date 2020/8/17 10:32
 */

public class bite8_17 {
    static String Serialize(TreeNode root) {
        if (root == null)return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll == null){
                sb.append("#" + "!");
                continue;
            }
            sb.append(poll.val + "!");

            queue.offer(poll.left);
            queue.offer(poll.right);

        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    static TreeNode Deserialize(String str) {
        if (str.length() == 0)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] split = str.split("!");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null){
                continue;
            }
            TreeNode left;
            TreeNode right;

            if (split[i].equals("#")){
                i++;
                left = null;
            }else {
                left = new TreeNode(Integer.parseInt(split[i++]));
            }

            if (split[i].equals("#")){
                i++;
                right = null;
            }else {
                right = new TreeNode(Integer.parseInt(split[i++]));
            }

            cur.left =  left;
            cur.right = right;
            queue.offer(left);
            queue.offer(right);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
//        String serialize = Serialize(root);
//        TreeNode treeNode = Deserialize(serialize);
//        Serialize(treeNode);
        String s = "5!4!#!3!#!2";
        TreeNode deserialize = Deserialize(s);
        Serialize(deserialize);


    }

}
