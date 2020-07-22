package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/7/22 10:27
 */

public class bite7_22 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            ArrayList<Character> al = new ArrayList<>();
            for (int i = 0; i < s1[0].length(); i++) {
                al.add(s1[0].charAt(i));
            }
            boolean isTrue = true;
            for (int i = 0; i < s1[1].length(); i++) {
                char c = s1[1].charAt(i);
                if (al.contains(c)){
                    al.remove(al.indexOf(c));
                }else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            if (n == 0)continue;
            String s2 = s1[n + 1];
            int len = s2.length();
            int index = Integer.parseInt(s1[s1.length-1]);
            ArrayList<String> al = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (s1[i].length() == len && !s1[i].equals(s2) && isBro(s1[i],s2)) {
                    al.add(s1[i]);
                }
            }
            Collections.sort(al);
            if (index <= al.size()){
                System.out.println(al.size());
                System.out.println(al.get(index-1));
            }

        }
    }

    private static boolean isBro(String s, String s2) {
        char[] chars = s.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]){
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String A = scanner.next();
//            String B = scanner.nextLine();
//            boolean b = isContain(A,B);
//            if (b) System.out.println("Yes");
//            else System.out.println("No");
//        }
//    }
//
//    private static boolean isContain(String a, String b) {
//        Map<Character,Integer> map = new HashMap<>();
//        //将A中的元素存入map
//        for (int i = 0; i < a.length(); i++) {
//            if (!map.containsKey(a.charAt(i))) {
//                map.put(a.charAt(i),1);
//            }else {
//                int val = map.get(a.charAt(i));
//                map.put(a.charAt(i),val+1);
//            }
//        }
//        //测试B的值是否在map中
//        for (int i = 1; i < b.length(); i++) {
////            char c = b.charAt(i);
////            System.out.println(c);
//            if (!map.containsKey(b.charAt(i))) {
//                return false;
//            }else {
//                int val = map.get(b.charAt(i));
//                map.put(b.charAt(i),val-1);
//                if (map.get(b.charAt(i))<0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.trim().split(" ");
            if (s.length < 5) {
                break;
            }
            int num = Integer.parseInt(s[0]);
            if (num > 1000) {
                break;
            }
            String key = s[num + 1];
            int index = Integer.parseInt(s[num + 2]);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 1; i < s.length - 2; i++) {
                if (isBroStr(s[i], key)) {
                    list.add(s[i]);
                }
            }
            System.out.println(list.size());
            Collections.sort(list);
            if (list.size() >= index) {
                System.out.println(list.get(index - 1));
            }
        }
    }

    public static boolean isBroStr(String source, String key) {
        if ((source.equals(key)) || (source.length() != key.length())) {
            return false;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            if (getCharNum(source, c) != getCharNum(key, c)) {
                return false;
            }
        }
        return true;
    }

    public static int getCharNum(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
