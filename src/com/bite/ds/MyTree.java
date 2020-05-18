package com.bite.ds;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/5/15 20:10
 */

public class MyTree {
    public static Node1 buildTree() {
        Node1 A = new Node1('A');
        Node1 B = new Node1('B');
        Node1 C = new Node1('C');
        Node1 D = new Node1('D');
        Node1 E = new Node1('E');
        Node1 F = new Node1('F');
        Node1 G = new Node1('G');
        Node1 H = new Node1('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 前序遍历   递归来实现
    void preOrderTraversal(Node1 root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node1 root){
        if(root == null) {
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.val+" ");
        preOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node1 root){
        if(root == null) {
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");

    }

    int size = 0;
    int getSize(Node1 root){
        if(root == null) {
            return size;
        }
//        System.out.print(root.val+" ");
        size++;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return size;
    }
    int size1 = 0;
    static int getSize2(Node1 root){

        if(root == null) {
            return 0;
        }

        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    static int leafSize = 0;
    static void getLeafSize1(Node1 root){
        if(root == null) {
            return;
        }

        if (root.left == null && root.right == null)leafSize++;
        getLeafSize1(root.left);
        getLeafSize1(root.right);


    }

    static int getLeafSize2(Node1 root){

        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)return 1;

        return getLeafSize2(root.left) + getLeafSize2(root.right) ;
    }

    int getKLevelSize(Node1 root,int k){
        if (root == null || k < 0)return 0;
        if (k == 1)return 1;
        return getKLevelSize(root.left,k - 1) + getKLevelSize(root.right,k - 1);
    }

    // 获取二叉树的高度

    static int getHeight(Node1 root){
        if (root == null)return 0;
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    Node1 find;
    Node1 find(Node1 root, int val){
        if (root == null)return null;
        if (root.val == val){
            find =root;
            return root;
        }

        Node1 node = find(root.left,val);
        if (node != null)return node;
        return  find(root.right,val);
    }

    void levelOrderTraversal(Node1 root){

        if(root == null) return;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            Node1 poll = queue.poll();
//            if (poll == null)continue;
            System.out.println(poll.val);
            queue.offer(poll.left);
            queue.offer(poll.right);
        }


    }

    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //1、求当前队列的大小  size
            int size = queue.size();
            List<Integer> list =  new LinkedList<>();
            //2、while(size > 0)  -->控制当前每一层的数据个数
            while (size > 0){
                Node1 poll = queue.poll();
                list.add((int) poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
                size--;
            }


        }


        return ret;
    }

    public boolean isFullTree(Node1 root){
        if(root == null) return true;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            Node1 poll = queue.poll();
            if ( poll== null){
                break;
            }else {
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }

        while ( !queue.isEmpty()){
            if (queue.poll() != null)
                return false;
        }
        return true;

    }

    /**
     * 迭代实现中序遍历
     * @param root
     */
    void inOrderTraversalNor(Node1 root){
        if (root == null)return;
        Stack<Node1> s = new Stack<>();

        s.push(root);
        Node1 cur = root;
        while (cur != null || !s.isEmpty()){
            while (cur != null ){
                s.push(cur.left);
                cur = cur.left;
            }
            Node1 top = s.pop();
            System.out.println(top.val);
            cur = top.right;
        }

    }

    void postOrderTraversalNor(Node1 root){
        if(root == null) return;
        Stack<Node1> stack = new Stack<>();
        Node1 cur = root;
        Node1 prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                System.out.print(cur.val+" ");
                stack.pop();
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        getLeafSize1(buildTree());
        System.out.println(getLeafSize2(buildTree()));
        System.out.println(leafSize);
        System.out.println(getHeight(buildTree()));
    }

}
class Node1 {
    public char val;
    public Node1 left;//左孩子-》左子树
    public Node1 right;//右孩子-》右子树
    public Node1(char val) {
        this.val = val;
    }
}





