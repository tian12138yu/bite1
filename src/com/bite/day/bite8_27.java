package com.bite.day;

import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author tjy
 * @Date 2020/8/27 17:36
 */

public class bite8_27 {
    static List<List<TreeNode>> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode3.left = treeNode4;
        bfs(root,0);
        for (List<TreeNode> list : res){
            for (TreeNode cur : list){
                System.out.print(cur.val);
            }
            System.out.println();
        }
    }

    private static void bfs(TreeNode root, int leve) {
        if (root == null) return;
        if (res.size() <= leve){
            res.add(new ArrayList<>());
        }
        List<TreeNode> treeNodes = res.get(leve);
        treeNodes.add(root);
        bfs(root.left,leve+1);
        bfs(root.right,leve+1);

    }


}
