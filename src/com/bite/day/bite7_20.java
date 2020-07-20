package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/7/20 10:25
 */

public class bite7_20 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            TreeSet<String> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s1.length(); j++) {
                    int index = symbol.indexOf(s1.charAt(j));
                    if (index != -1)sb.append(number.charAt(index));
                    if (sb.length() == 3)sb.append("-");
                }
//                sb.toString();
                set.add(sb.toString());
            }

            for (String ss : set){
                System.out.println(ss);
            }
            System.out.println();
        }
    }
    
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> al = new ArrayList<>();

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            dfs(1,m,n);
            for(ArrayList<Integer> l : res) {
                int i = 0;
                for(; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    private static void dfs(int i, int m, int n) {
        if (m == 0)res.add(new ArrayList<>(al));
        else {
            for (int j = i; j <= n && j <= m; j++) {
                al.add(j);
                dfs(j+1,m - j,n);
                al.remove(al.size()-1);
            }
        }
    }

    public static void main3(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =  br.readLine();
        int n = Integer.parseInt(s);
        List<String> al = new ArrayList<>();
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            if (al.contains(ss[i])){
                al.remove(ss[i]);
            }else {
                al.add(ss[i]);
            }
        }
        char c = al.get(0).charAt(0);
        char c1 = al.get(1).charAt(0);
        if (c > c1){
            System.out.println(c1 + " " + c);
        }else {
            System.out.println(c + " " + c1);
        }


    }

    /**
     * 单调栈解法：
     * 因为要求的是离得近的左右且小于自己的。
     * 遍历数组，如果当前栈为空或者当前栈顶元素小于当前数组下标值，则把数据压入栈中，直到碰到小于栈顶元素的，
     * 把栈顶元素弹出，表示弹出的数据的左边和右边的小值都找到了，记录下就行。
     * 一直循环，直到最后，栈里剩的元素表示右边没有比他们小的，然后依次弹出记录他们下一个为左边的小值，右边为-1。
     * 最后一个左右都为-1.
     *
     *
     * @param arr
     * @return
     */
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        // 排除两种特例：null 空数组[]
        if (arr == null || arr.length < 1) {
            return null;
        }
        // 单调栈初始化
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int cur;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
                // 满足从栈顶到栈底单调递减时，压入
                stack.push(i);
                i++;
            } else {
                // 不满足从栈顶到栈底单调递减时，弹出
                cur = stack.pop();
                res[cur][0] = stack.isEmpty() ? -1 : stack.peek();
                res[cur][1] = i;
            }
        }
        // 清算栈中剩余的元素，这些元素右边没有比它小的数字
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res[cur][0] = stack.isEmpty() ? -1 : stack.peek();
            res[cur][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        String[] numbers = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        int[][] res = getNearLessNoRepeat(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
