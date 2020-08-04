package com.bite.day;

import com.bite.TreeNode;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/8/4 11:13
 */

public class bite8_4 {

    public static void main(String[] args) {

    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        dfs(root1,al1);
        dfs(root2,al2);
        int i = 0,j = 0;
        while (i < al1.size() && j < al2.size()){
            int integer = al1.get(i);
            int integer1 = al2.get(j);
            if (integer < integer1){
                res.add(integer);
                i++;
            }else {
                res.add(integer1);
                j++;
            }
        }
        while (i < al1.size()){
            res.add(al1.get(i));
        }

        while (j < al2.size()){
            res.add(al2.get(j));
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> al) {
        if (root == null)return;
        dfs(root.left,al);
        al.add(root.val);
        dfs(root.right,al);
    }
}
