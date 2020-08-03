package com.bite.day;

import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tjy
 * @Date 2020/8/1 11:23
 */

public class bite8_1 {
    /**
     * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
     *
     * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
     * 输出：[7,4,1]
     * 解释：
     * 所求结点为与目标结点（值为 5）距离为 2 的结点，
     * 值分别为 7，4，以及 1
     * @param root
     * @param target
     * @param K
     * @return
     */
    List<Integer> res = new ArrayList<>();
    List<Boolean> lr = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        dfs(root,target,treeNodes);
        int size1 = treeNodes.size();
        int size2 = lr.size();
        if (size1 != 0){
            if (size1 < K){
                if (lr.get(0)){
                    dfsResult(root.right,1,K-size1);
                }else {
                    dfsResult(root.left,1,K-size1);
                }
                for (int i = 1; i < size1; i++) {
                    if (lr.get(i)){
                        dfsResult(treeNodes.get(i).right,1,K-size1+i);
                    }else {
                        dfsResult(treeNodes.get(i).left,1,K-size1+i);
                    }
                }
            }
        } else {
            for (int i = 1; i <= K; i++) {
                if (i == K)res.add(treeNodes.get(size1-i).val);
                if (lr.get(size2 -i)){
                    dfsResult(treeNodes.get(size1-i).right,1,K-i);
                }else {
                    dfsResult(treeNodes.get(size1-i).left,1,K-i);
                }
            }
        }

        dfsResult(target,0,K);
        return res;

    }

    private void dfsResult(TreeNode target, int i, int k) {
        if (target == null)return;
        if (i == k){
            res.add(target.val);
            return;
        }
        dfsResult(target.left,i+1,k);
        dfsResult(target.right,i+1,k);

    }

    private boolean dfs(TreeNode root, TreeNode target,List<TreeNode> al) {
        if (root == null)return false;
        if (root == target)return true;
        al.add(root);
        lr.add(true);
        if (dfs(root.left,target,al))return true;
        lr.remove(lr.size()-1);
        lr.add(false);
        if (dfs(root.right,target,al))return true;
        lr.remove(lr.size()-1);
        al.remove(al.size()-1);
        return false;
    }


}


















