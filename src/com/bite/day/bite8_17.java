package com.bite.day;

import com.bite.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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


    public static void main1(String[] args) {
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



    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            HashSet<Character> set = new HashSet<>();
            {
                set.add('}');
                set.add(']');
                set.add(')');
            }
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> al = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[' || c == '(' || c == '{'){
                    stack.push(i);
                }
                else if (set.contains(c)){
                    Integer pop = stack.pop();
                    al.add(pop);
                    map.put(pop,i);
                    count++;
                }

            }
            System.out.println(count);
            Collections.sort(al);
            for (int x : al){
                System.out.println(x);
                System.out.println(map.get(x));
            }
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            String ss = br.readLine();
            if (n == 0) {
                System.out.println(ss);
                break;
            }
            String[] s1 = ss.split(" ");
            if (n >= s1.length){
                StringBuilder sb = new StringBuilder(s);
                System.out.println(sb.reverse().toString());
                break;
            }
            for (int i = n; i < s1.length; i++) {
                System.out.print(s1[i] + " ");
            }

            for (int i = n-1; i > 0; i--) {
                System.out.print(s1[i] + " ");
            }
            System.out.println(s1[0]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        out:while ((s = br.readLine()) != null){
            String ss = br.readLine();
            if (s.length() != ss.length()) {
                System.out.println(false);
                break;
            }
            StringBuilder sb = new StringBuilder(s);
            StringBuilder sb1 = new StringBuilder(ss);

            in:for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                char c1 = ss.charAt(i);
                if (c != c1){
                    System.out.println(dfs(sb, sb1, s, c1, i, c));
                    break out;
                }
            }
        }
    }

    private static boolean dfs(StringBuilder sb, StringBuilder sb1, String s, char c1,int i,char c) {
        int i1 = s.indexOf(c1);
        if (i1 == -1 || s.length() <= 0)return false;
        sb.replace(i,i+1, c1 +"");
        sb.replace(i1,i1+1, c +"");
        boolean b = sb.toString().equals(sb1.toString());
        if (b)return b;
        sb.replace(i,i+1,c+"");
        sb.replace(i1,i1+1, c1 +"");
        return dfs(sb,sb1,s.substring(i1+1),c1,i,c);

    }

}
