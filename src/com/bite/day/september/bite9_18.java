package com.bite.day.september;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/9/18 16:50
 */

public class bite9_18 {

    public static void main1(String[] args) {
        float a = 55.00F;
        double b = 45.44567;
        long l = 456456457;

    }

    /**
     * 5
     * 1,2,5
     */
    static List<List<Integer>> als;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s= br.readLine()) != null) {
            int money = Integer.parseInt(s);
            String[] split = br.readLine().split(",");
            int len = split.length;
            int[] a = new int[len];
            als = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                a[i] = Integer.parseInt(split[i]);
            }

            dfs(money,0,0,split.length,a,new ArrayList<Integer>());

            System.out.println(als.size());
            for (int i = 0; i < als.size(); i++) {
                System.out.println(als.get(i));
            }
        }
    }

    private static void dfs(int money, int i, int sum,int len,int[] a,List<Integer> al) {
        if (sum == money) {
            als.add(new ArrayList<>(al));
            return;
        }

        for (int j = i; j < len; j++) {
            if (sum + a[j] <= money) {
                al.add(a[j]);
                dfs(money,j,sum + a[j],len,a,al);
                al.remove(al.size() - 1);
            }else
                break;
        }
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s= br.readLine()) != null) {
            int n = Integer.parseInt(s);
            Map<Character,Node> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s1 = br.readLine();
                char c = s1.charAt(0);
                char c1 = s1.charAt(s1.length()-1);
                Node cur ;
                Node next = new Node(c1);
                if (map.containsKey(c)) {
                    cur = map.get(c);
                }else {
                    cur = new Node(c);
                }
                cur.next = next;
                map.put(c,cur);
                map.put(c1,next);
            }

            for (Map.Entry<Character,Node> entry : map.entrySet()) {
                Node value = entry.getValue();
                if (fun(value)) {
                    System.out.println("Y");
                    return;
                }

            }
            System.out.println("N");
        }
    }

    private static boolean fun(Node value) {
        Node low = value;
        Node fast = value.next;
        while (fast != null) {
            if (fast == fast)
                return true;
            low = low.next;
            fast = fast.next.next;
        }
        return false;
    }


}

class Node {
    char c;
    Node next = null;

    public Node(char c) {
        this.c = c;
    }
}
