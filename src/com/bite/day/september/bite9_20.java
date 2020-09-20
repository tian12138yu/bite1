package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/9/20 13:37
 */

public class bite9_20 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs1(nums,0,new ArrayList<Integer>());
        return res;
    }

    private void dfs1(int[] nums, int i, ArrayList<Integer> al) {
        res.add(new ArrayList<>(al));
        for (int j = i; j < nums.length; j++) {
            al.add(nums[j]);
            dfs1(nums,i+1,al);
            al.remove(al.size()-1);
        }
    }

    public static void main1(String[] args) {
        int a = 10,b = 5,c = a+++b,d = a+++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        char[] chars = {'a','c'};
        String s = "ac";
        System.out.println(s.equals(chars));
        ArrayList<Number> numbers = new ArrayList<>();


    }


    /**
     * 小A正在学画画，现在，线稿已经画好了，只剩下涂色部分了。但是小A发现，他的颜料不够了。每一块颜料能涂一个色块，每一个色块的颜色是事先决定好了的。 由于颜料不够，小A只能尽其所能来涂色。如果一个色块没有了颜料，就不能涂色。现在，给你画中需要的色块颜色，和小A现在手上有的颜料，请你计算小A能涂多少个色块。
     *
     * 输入描述
     * 输入包含两个字符串，都仅包含大写字母，每一种字母代表一种颜色。 第一个字符串S代表小A手上的颜料，第二个字符串T代表画需要的颜料。
     *
     * 1≤|S|,|T|≤1000
     *
     * 输出描述
     * 输出包含一个数，即最多能涂多少个色块。
     *
     *
     * 样例输入
     * AAB
     * ABC
     * 样例输出
     * 2
     */

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            String s1 = br.readLine();
            char[] chars = s.toCharArray();
            char[] chars1 = s1.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars1.length; i++) {
                if (map.containsKey(chars1[i])) {
                    map.put(chars1[i],map.get(chars1[i]) + 1);
                }else {
                    map.put(chars1[i],1);
                }
            }

            int res = 0;
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    if (map.get(chars[i]) - 1 == 0)map.remove(chars[i]);
                    else
                    map.put(chars[i], map.get(chars[i]) - 1);
                    res++;
                }
            }
            System.out.println(res);
        }
    }


    /**
     * 由于新冠肺炎疫情的爆发，小明养在宿舍的小昆虫已经很久很久都没有人管了。小昆虫已经饿的不行了，必须出来找东西吃，可是出来之后需要走出一个迷宫。
     * 小昆虫每次可以朝上、下、左、右四个方向之一走一步，且只要走出任意一条边界线即可逃出迷宫。这只小昆虫曾感染过X星的一种奇异病毒，
     * 目前还没有发现任何副作用，但是却拥有了一项特异功能——破坏障碍物。
     *
     * 假设小昆虫在一个N*M的迷宫中，"@"代表小昆虫的初始位置，"."代表可以通过的空地，"*"代表可以破坏的障碍物，"#"代表不可破坏的障碍物。
     * 请问小昆虫最少需要使用多少次特异功能才可以逃出迷宫？
     *
     *
     *
     * 输入描述
     * 多组数据，第1行有1个正整数T，表示有T组数据。（T<=100）
     *
     * 对于每组数据，第1行有两个整数N和M。(1<=N, M<=1000)
     *
     * 接着N行，每行有一个长度为M的字符串，表示N*M的迷宫。
     *
     * 输出描述
     * 输出一个整数，表示使用特异功能的最少次数。如果小昆虫不能走出迷宫，则输出-1。
     *
     *
     * 样例输入
3
3 3
###
#@*
***
3 4
####
#@.*
**.*
3 3
.#.
#@#
.#.
     * 样例输出
     * 1
     * 0
     * -1
     */

    static boolean[][] bb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            for (int i = 0; i < n; i++) {
                res1 = Integer.MAX_VALUE;
                String s1 = br.readLine();
                int x = s1.charAt(0) - '0';
                int y = s1.charAt(2) - '0';
                int a = 0;
                int b = 0;
                char[][] c = new char[x][y];
                bb = new boolean[x][y];
                for (int j = 0; j < x; j++) {
                    String s2 = br.readLine();
                    for (int k = 0; k < y; k++) {
                        c[j][k] = s2.charAt(k);
                        if (c[j][k] == '@'){
                            a = j;
                            b = k;
                        }
                    }
                }

                dfs(c,a,b,0,x,y);
                if (res1 == Integer.MAX_VALUE)
                    System.out.println(-1);
                else
                System.out.println(res1);
            }
        }
    }
    static int[][] a = {{0,1},{0,-1},{1,0},{-1,0}};
    static int res1 = Integer.MAX_VALUE;
    private static void dfs(char[][] c,int i,int j,int sum,int x,int y) {
        if (sum > res1)return;
        if (bb[i][j])return;
        if (c[i][j] == '#')return;
        if (c[i][j] == '*')sum++;
        bb[i][j] = true;
        for (int k = 0; k < 3; k++) {
            if (i + a[k][0] == x || i +a[k][0] < 0 || j+a[k][1] == y || j+a[k][1] < 0){
                res1 = Math.min(res1,sum);
            }else {
                dfs(c,i+a[k][0],j+a[k][1],sum,x,y);
            }
        }
        bb[i][j] = false;
    }

}
