package com.bite.ds;

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



    public static void main(String[] args) {
        getLeafSize1(buildTree());
        System.out.println(getLeafSize2(buildTree()));
        System.out.println(leafSize);
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





