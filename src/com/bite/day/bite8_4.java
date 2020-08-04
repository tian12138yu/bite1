package com.bite.day;

import com.bite.TreeNode;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    /**
     * Example1:
     * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
     * Example2:
     * 给出 numbers = [15, 2, 7, 11], target = 9, 返回 [1, 2].
     * 挑战
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            al.add(numbers[i]);
        }
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int x = target - numbers[i];
            if (al.contains(x)){
                if (al.indexOf(x) < i){
                    res[0] = al.indexOf(x);
                    res[1] = i;
                }else {
                    res[0] = i;
                    res[1] = al.indexOf(x);
                }
            }
        }
        return res;
    }

    public int singleNumber(int[] A) {
        // write your code here
        int x = A[0];
        for (int i = 1; i < A.length; i++) {
            x = x ^ A[i];
        }
        return x;
    }
}
