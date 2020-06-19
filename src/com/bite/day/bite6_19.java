package com.bite.day;

import com.bite.TreeNode;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/19 13:02
 */

public class bite6_19 {
    static boolean a;
    private int x = 0;

    public bite6_19() {
        System.out.println("b");
    }

    public static void main1(String[] args) {
//        System.out.println(a);
//        System.out.println(new bite6_19().x);
        bite6_19 b = new bite6_19();


    }


    static List<String> res = new ArrayList<>();
    static List<Integer> al;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            res.clear();
            int n = sc.nextInt();
            int[] array = new int[n];
            al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                array[i] = x;
                al.add(x);

            }
//        Arrays.sort(array);
//        Collections.sort(al);
            dfs(array,0);
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                String s1 = res.get(i);
                for (int j = 0; j < s1.length(); j++) {
                    System.out.print(s1.charAt(j));
                }
                System.out.println();


            }
        }

    }


    private static void dfs(int[] array, int x) {
        if(x == array.length - 1) {
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for (int i = 0; i < al.size(); i++) {
                stack.push(al.get(i));
                while (!stack.isEmpty() && j < al.size() && array[j] == stack.peek()){
                    stack.pop();
                    j++;
                }
            }
            if (stack.isEmpty()){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.length; i++) {
                    sb.append(array[i]+" ");
                }
                res.add(sb.toString()); // 添加排列方案
            }
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = x; i < array.length; i++) {
            if(set.contains(array[i])) continue; // 重复，因此剪枝
            set.add(array[i]);
            swap(array,i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(array,x + 1); // 开启固定第 x + 1 位字符
            swap(array,i, x); // 恢复交换
        }
    }

    static void swap(int[] array,int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }




    static ArrayList<String> l=new ArrayList<>();    //储存结果
    public static void main3(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            l.clear();    //静态变量，每次先清空
            int nums=in.nextInt();
            int[] id=new int[nums];
            Stack<Integer> stack=new Stack<>();
            for(int i=0;i<nums;i++) {
                id[i]=in.nextInt();
            }
            trainOut(id,0,stack,"",0);
            Collections.sort(l);    //对结果集排序
            for(String str:l) {
                System.out.println(str);
            }
        }
        in.close();
    }
    //i为入栈次数，n为出栈次数，str存储一趟结果
    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n) {
        if(n==id.length) {
            l.add(str);    //如果所有火车均出栈则将当前结果保存
        }
        if(!s.empty()) {       //栈非空时出栈
            int temp=s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp);    //恢复现场
        }
        if(i<id.length) {    //若所有火车没有都入栈则入栈
            s.push(id[i]);
            trainOut(id,i+1,s,str,n);
            s.pop();        //恢复现场
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null)return;
        swap(root);
    }

    private void swap(TreeNode root) {
        if (root == null)return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        swap(root.left);
        swap(root.right);
    }


}

//class s{
//    public s() {
//        System.out.println("s");
//    }
//}
