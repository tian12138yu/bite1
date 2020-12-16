package com.bite.day.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tjy
 * @Date 2020/12/16 20:36
 */

public class T12_16 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }


    public static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] chars1 = s.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String s1 = ""+i;
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    s1 += j;
                }
            }
            strings.add(s1);
        }

        for (int i = 0; i < strings.size(); i++) {
            String s2 = strings.get(i);
            String c = chars1[s2.charAt(0) - '0'];
            for (int j = 1; j < s2.length(); j++) {
                if (!chars1[s2.charAt(j) - '0'].equals(c))
                    return false;
            }

        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String str) {
        if(pattern == null || str==null) return false;
        String[] string = str.split(" ");
        if(pattern.length() != string.length) return false;
        HashMap<Character,String> map = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char tmp = pattern.charAt(i);
            //key已经在
            if(map.containsKey(tmp)){
                //不对应就失败
                if(!map.get(tmp).equals(string[i])) return false;
            }
            //key不存在
            else{
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(string[i])) return false;
                else
                    //添加k-v值
                    map.put(tmp,string[i]);
            }
        }
        return true;
    }
}
