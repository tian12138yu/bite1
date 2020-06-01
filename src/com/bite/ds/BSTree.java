package com.bite.ds;

/**
 * @Author tjy
 * @Date 2020/5/28 19:56
 */

public class BSTree {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    public boolean insert(int val) {
        Node node = new Node(val);
        if(root == null) {
            root = node;
            return true;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            if (cur.val == val) {
                return false;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;

            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        //cur为空  位置找到  进行插入
        //两种情况-》
        if (parent.val < val) {
            parent.right = node;
        }else {
            parent.left = node;
        }

        return true;
    }
    public Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if(cur.val == val) {
                return cur;
            }else if(cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.val == key) {
                removeNode(parent,cur);
                return true;
            }else if(key < cur.val) {
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        return false;
    }

    /**
     * 删除节点需要先判断当前删除节点是否拥有孩子，如果只有一个孩子，就直接把孩子赋给当前节点的父亲节点。
     * 如果两个孩子都有，需要找到左树中的最大值或者右树中的最小值，将要删除的节点的值变成它，
     * 然后将这个替代值删除即可。
     * 因为这个替代值是最大或最小值，是只有一个孩子，删除较为容易。
     * @param parent
     * @param cur
     */
    public void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }



}
