package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author tjy
 * @Date 2020/7/13 12:47
 */

public class bite7_13 {

    /**
     * 4 4 10
     * 1 0 0 1
     * 1 1 0 1
     * 0 1 1 1
     * 0 0 1 1
     */
    static int n, m, maxRemainEnergy = 0;
    static int[][] map;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> linkedlist = new LinkedList<>();

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] ss = s.split(" ");
             n = Integer.parseInt(ss[0]);
             m = Integer.parseInt(ss[1]);
            int p = Integer.parseInt(ss[2]);
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                String[] s2 = s1.split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(s2[j]);
                }
            }

            runMap(0, 0, p);

            //输出
            if (!flag)
                System.out.println("Can not escape!");
            else
                System.out.println(path);



        }
    }


    public static void runMap(int x, int y, int energy) {
        if (energy < 0 || x<0 || y<0 || x>=n || y>= m || map[x][y] != 1) return;
        else {
            linkedlist.offer("[" + x + "," + y + "]");
            map[x][y] = 0;
            if (x == 0 && y == m - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1; linkedlist.removeLast();
                flag = true; return;
            }
            runMap(x, y+1, energy-1);
            runMap(x+1, y, energy);
            runMap(x-1, y, energy-3);
            runMap(x, y-1, energy-1);
            map[x][y] = 1;linkedlist.removeLast();
        }
    }

    public static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedlist.iterator();
        while (iterator.hasNext())
            sb.append(iterator.next() + ",");
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        path = sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            long sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                String[] s2 = s1.split(" ");
                int  x =  Integer.parseInt(s2[0]);
                int y = Integer.parseInt(s2[1]);
                if (x == 1){
                    sum += y;
                    pq.offer(y);
                }else {
                    sum -= y;
                    pq.remove(y);
                }
                int peek = pq.peek();
                System.out.println(peek);
                System.out.println(peek < sum - peek ? "Yes" : "No");
            }
        }
    }

}
