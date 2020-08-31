package com.bite.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/8/31 11:02
 */

public class bite8_31 {


    /**
     *有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     *
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     *
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     *
     * 你可以自由地在房间之间来回走动。
     *
     * 如果能进入每个房间返回 true，否则返回 false。
     */
    static boolean[] b;
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        b = new boolean[rooms.size()];
        b[0] = true;
        dfs(0,rooms);
        boolean res = true;
        for (boolean b1 : b){
            res &= b1;
        }
        return res;
    }

    private static void dfs(int x, List<List<Integer>> rooms) {
        if (b[x] && x != 0)return;
        b[x] = true;
        for (int i : rooms.get(x))
            dfs(i,rooms);

    }

    public static void main1(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> al3 = new ArrayList<>();
        ArrayList<Integer> al4 = new ArrayList<>();
        al1.add(1);
        al2.add(2);
        al3.add(3);
        List<List<Integer>> als = new ArrayList<>();
        als.add(al1);
        als.add(al2);
        als.add(al3);
        als.add(al4);

        System.out.println(canVisitAllRooms(als));
    }

    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        if (values.size() == 0)return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (ArrayList<String> al : values){
            HashSet<String> set = new HashSet<>(al);
            for (String s : set){
                if (map.containsKey(s)){
                    if (map.get(s)+1 == values.size()){
                        res.add(s);
                    }
                    map.put(s,map.get(s)+1);
                }else {
                    map.put(s,1);
                }

            }
        }
        return res;
    }


    public int question (int a, int b) {
        // write code here
        double  x = 1;
        for (; x <= 500; x++) {
            if (Math.sqrt(x + a) % 1 == 0 && Math.sqrt(x + b) % 1 == 0)
                return (int)x;
        }
        return -1;
    }

    public static int translateNum (int num) {
        // write code here

        String s = String.valueOf(num);
        if (s. length() <= 1)return s.length();
        return dfs(s);


    }

    private static int dfs(String s) {
        if (s.length() == 1 || s.length() == 0)return 1;
        int res;
        if (Integer.parseInt(s.substring(0,2)) > 25){
            res = dfs(s.substring(1)) ;
        }else {
            res = dfs(s.substring(1)) +
                    dfs(s.substring(2));
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(8 + 1) % 1);
//        String s = "fdasdasd";
//        System.out.println(s.substring(2));
        System.out.println(translateNum(12158));
    }


}
