package com.bite.day;

import com.bite.TreeNode;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/15 10:18
 */

public class bite8_15 {

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public static boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0)return true;
        if (pattern.length == 0)return false;
        if (pattern.length == 2 && pattern[0] == '.' && pattern[1] == '*')return true;
        int j = 0,i = 0;
        for (; i < str.length && j < pattern.length; i++,j++) {
            if (str[i] != pattern[j]){
                if (pattern[j] == '.')continue;
                else if (pattern[j] == '*'){
                    char c = pattern[j-1];
                    if (c == '.'){
                        continue;
                    }
                    if (c != str[i])return false;
                    while (i < str.length && str[i] == c){
                        i++;
                    }
                }
                else if (j+1 < pattern.length && pattern[j+1] == '*'){
                    j += 2;
                    if (j >= pattern.length || (pattern[j] != '.' && str[i] != pattern[j]))return false;
                }else return false;
            }
        }
        if (i != 0 && i < str.length)return false;
        while (j < pattern.length){
            if (pattern[j] != '*' && (j+1 >= pattern.length || pattern[j+1] != '*')){
                return false;
            }

            j++;
        }

        return true;
    }

    public boolean match1(char[] str, char[] pattern){
        if(str ==null || pattern ==null) return false;
        return matchCore(str,0,pattern,0);
    }
    private boolean matchCore(char[] str,int s, char[] pattern,int p){
        //下面4行是递归结束标志，两个指针都指到了最后，才是匹配，否则不匹配
        if(s == str.length && p == pattern.length)
            return true;
        if(s<str.length && p == pattern.length)
            return false;

        //虽然比的是p的位置，但是P后面出现*时，规则需要改变。
        if(p+1 < pattern.length && pattern[p+1] == '*'){
            //出现了*，并且s和p指向的相同，三种情况并列
            if((s<str.length && pattern[p] =='.') || (s<str.length && pattern[p]==str[s])){
                return matchCore(str,s,pattern,p+2)||matchCore(str,s+1,pattern,p)||matchCore(str,s+1,pattern,p+2);
            }
            //出现了*，并且s和p指向的不同，那就把*前面的字符理解出现了次，p+2
            else{
                return matchCore(str,s,pattern,p+2);
            }
        }
        //说明p后面如果不是*，那么就进行常规判断。相同就s+1,p+1
        if(s<str.length && (pattern[p]==str[s] || pattern[p] =='.')){
            return matchCore(str,s+1,pattern,p+1);
        }
        //p后面又不是*，也没有'.',返回false
        return false;
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedHashMap<TreeNode, Integer> map = new LinkedHashMap<>();
        Stack<TreeNode> s = new Stack<>();
        map.put(pRoot,1);
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null){
                queue.offer(poll.left);
                map.put(poll.left,map.get(poll) + 1);
            }
            if (poll.right != null){
                queue.offer(poll.right);
                map.put(poll.right,map.get(poll) + 1);
            }
        }
        boolean b = false;
        boolean b1 = false;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<TreeNode,Integer> entry :map.entrySet()){
            int value = entry.getValue();
            if (value % 2 == 0){
                if (b1){
                    res.add(new ArrayList<>(al));
                    al = new ArrayList<>();
                }
                b = true;
                b1 = false;
                s.push(entry.getKey());
            }
            if (value % 2 == 1){
                if (b){
                    while (!s.isEmpty()) {
                        al.add(s.pop().val);
                    }
                    res.add(new ArrayList<>(al));
                    al= new ArrayList<>();
                }
                al.add(entry.getKey().val);
                b = false;
                b1 = true;
            }
        }
        while (!s.isEmpty()){
            al.add(s.pop().val);
        }
        if (!al.isEmpty())res.add(new ArrayList<>(al));
        return res;
    }

    public static void main1(String[] args) {
        char[] chars = {'a','a'};
        char[] chars1 = {'.','*'};
        System.out.println(match(chars, chars1));
    }

    /**
     * 1
     * 2178 8712
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s= br.readLine()) != null){
            TreeMap<Long, Long> map = new TreeMap<>();

//            BigInteger n =BigInteger.valueOf(Long.parseLong(s));
            int n = Integer.parseInt(s);
            if (n >= 8712){
                map.put(2178L,8712L);
            }
            if (n >= 21978){
                map.put(21978L,87912L);
            }

            if (n >= 219978){
                map.put(219978L,879912L);
            }

            if (n >= 2199978){
                map.put(2199978L,8799912L);
            }

            if (n >= 21782178){
                map.put(21782178L,87128712L);
            }
            if (n >= 21999978){
                map.put(21999978L,87999912L);
            }
            if (n >= 219999978){
                map.put(219999978L,879999912L);
            }
//            for (long i = 100000001; i <= n; i++) {
//                if (resver(i) == i * 4){
//                    map.put(i,i*4);
//                }
//            }

            System.out.println(map.size());
            for (Map.Entry<Long,Long> entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }
    }

    private static long resver(long i) {

        StringBuilder sb = new StringBuilder(String.valueOf(i));
        StringBuilder reverse = sb.reverse();

        return Long.parseLong(reverse.toString());
    }


    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s= br.readLine()) != null){
            int n = Integer.parseInt(s);
            HashMap<String,String> map = new HashMap<String,String>();
            for (int i = 0; i < n; i++) {
                String[] s1 = br.readLine().split(" ");
                map.put(s1[0],s1[1]);
            }
            int count = 0;

            for (Map.Entry<String,String> entry : map.entrySet()) {
                HashMap<String, String> map1 = new HashMap<>(map);
                String value = entry.getValue();
                String key = entry.getKey();
                map1.remove(key);
                boolean b = dfs(value,key,map1);
                if (b)count++;
            }

            System.out.println(count);

        }
    }

    private static boolean dfs(String next, String root, HashMap<String, String> map) {

        if (!map.containsKey(next))return false;
        if (map.get(next).equals(root))return true;
        String s = map.get(next);
        map.remove(s);
        return dfs(s,root,map);
    }

    static class Titck{
        String qi;
        String mu;

        public Titck(String qi, String mu) {
            this.qi = qi;
            this.mu = mu;
        }
    }



    public static void main4(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s= br.readLine()) != null){
            String[] s1 = s.split(" ");
            int n = Integer.parseInt(s1[0]);//订单数量
            int m = Integer.parseInt(s1[1]);//关系数量

            Map<Integer,Integer> map = new HashMap<>();
            List<Integer> one = new ArrayList<>();
            List<Integer> two = new ArrayList<>();
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] s2 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);
                int y = Integer.parseInt(s2[1]);
                map.put(x,y);
                one.add(x);
                two.add(y);
            }

        }
        Thread.currentThread();
        ThreadLocal<Integer> local = new ThreadLocal<>();
        local.set(5);
    }

    class Node{
        int x;
        int y;
        Node next;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
