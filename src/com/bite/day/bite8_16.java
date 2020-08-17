package com.bite.day;

import com.bite.TreeNode;

import java.lang.reflect.Method;

/**
 * @Author tjy
 * @Date 2020/8/16 10:01
 */

public class bite8_16 {


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null){
            return pNode.right;
        }
        return null;
    }

    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null)return  null;
        TreeNode res = null;
        TreeNode node1 = KthNode(pRoot.left,k);
        if (node1 != null){
            res = node1;
        }
        count++;
        if (count == k)res = pRoot;
        TreeNode node2 = KthNode(pRoot.right,k);
        if (node2 != null){
            res = node2;
        }

        return res;
    }


    public static void main(String[] args) throws Exception {
        Class<?> object = Class.forName("java.lang.String");
        Method[] methods = object.getMethods();
        ClassLoader classLoader = object.getClassLoader();
        System.out.println(classLoader);
        String s = (String)object.newInstance();
        System.out.println(s);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}