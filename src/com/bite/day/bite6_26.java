package com.bite.day;

import com.bite.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/26 13:52
 */

public class bite6_26 {
    /**
     * 判断二叉树是否平衡：
     * 任意节点的两个孩子高度不超过一
     * @param root
     * @return
     */
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null)return true;

        return bfs(root) != -1;

    }

    private int bfs(TreeNode root) {
        if (root == null)return 0;
        int i = bfs(root.left);
        if (i == -1)return -1;
        int j = bfs(root.right);
        if (j == -1)return -1;
        int abs = Math.abs(i - j);
        int max = Math.max(i, j);
        return  abs > 1 ? -1 : max+1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int al1 = 0;
            ArrayList<Integer> al2 = new ArrayList<>();
            int al3 = 0;
            double al4 = 0;
            int cuont4 = 0;
            int max = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                switch (x % 5){
                    case 0 :
                        if (x % 5 == 0 && x % 2 == 0) al1 += x;
                        break;
                    case 1:
                        al2.add(x);break;
                    case 2 :al3++;break;
                    case 3 :al4 += x; cuont4++;break;
                    case 4 :if (x > max)max = x;break;
                    default:break;
                }
            }
            int al2sum = 0;
            for (int i = 0; i < al2.size(); i++) {
                if (i % 2 == 0)al2sum +=al2.get(i);
                else al2sum -= al2.get(i);
            }

            String s = String.format("%.1f", al4 / cuont4);

            if (al1 == 0)
                System.out.print("N" + " ");
            else
                System.out.print(al1 + " ");
            if (al2sum == 0)
                System.out.print("N" + " ");
            else {
                System.out.print(al2sum + " ");
            }
            if (al3 == 0)
                System.out.print("N" + " ");
            else
                System.out.print( al3 + " ");
            if (cuont4 == 0)
                System.out.print("N" + " ");
            else
                System.out.print(s + " ");
            if (max == 0)
                System.out.print("N");
            else
                System.out.print(max);




        }


    }
}
