package com.bite;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/9 13:38
 */

public class bite5_9 {

    public static void main(String[] args) {
        String s = "1+1=2";
//        String[] mysplit = Mysplit(s, "=");
//        System.out.println(Arrays.toString(mysplit));
        int i = myIndexOf(s, "=");
        System.out.println(i);
    }

    /**
     * 实现方法 split, 能够指定分割符将字符串拆分成字符串数组(不必支持正则表达式)
     */
    public static String[] Mysplit(String s,String sp){
        int i = s.indexOf(sp);
        String substring = s.substring(0, i);
        String substring1 = s.substring(i + 1, s.length());
        String[] ss = new String[]{substring,substring1};
        return ss;
    }

    /**
     *实现方法 replace, 能够替换字符串中的某个部分
     */
    public String Myreplace(String s,String old,String rep){
        String[] split = s.split(old);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(split[0]);
        stringBuilder.append(rep);
        stringBuilder.append(split[1]);
        return stringBuilder.toString();
    }

    /**
     * 实现方法 indexOf, 能够找出字符串子串存在的位置
     *
     */
    public static int myIndexOf(String s ,String findTo){
        char[] chars = s.toCharArray();
        char[] chars1 = findTo.toCharArray();
        out:for (int i = 0; i < chars.length; i++){
            if (chars[i] == chars1[0]){
                int temp = i;
                int j = 1;
                boolean a = true;
                in:for (; j < chars1.length; j++){
                    if (chars[i] != chars1[j]){
                        a =false;
                        break in;
                    }
                }
                if (a){
                    return temp;
                }else {
                    continue ;
                }

            }
        }
        return -1;
    }

    /**
     * 实现方法 contains, 能够判定字符串中是否包含子串
     */

    public boolean myContains(String s ,String con){
        char[] chars = s.toCharArray();
        char[] chars1 = con.toCharArray();
        out:for (int i = 0; i < chars.length; i++){
            if (chars[i] == chars1[0]){
                int temp = i;
                int j = 1;
                boolean a = true;
                in:for (; j < chars1.length; j++){
                    if (chars[i] != chars1[j]){
                        a =false;
                        break in;
                    }
                }
                if (a){
                    return true;
                }else {
                    continue ;
                }

            }
        }
        return false;
    }

    /**
     * 实现方法 compareTo, 能够实现按照字典序比较字符串大小
     */

    public int myCompareTo(String s1,String s2){
        if (s1.length() != s2.length())return s1.length() - s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int temp = 0;
        while (temp < s1.length()){
            if (chars1[temp] != chars2[temp]){
                return chars1[temp] - chars2[temp];
            }
            temp++;
        }
        return 0;
    }



}
