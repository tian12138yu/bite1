package com.bite.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/8/5 10:29
 */

public class bite8_5 {

    /**
     *给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
     *
     * 说明：
     *
     * 分隔时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     * 示例 2：
     *
     * 输入:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * 输出:
     * [
     *   "pine apple pen apple",
     *   "pineapple pen apple",
     *   "pine applepen apple"
     * ]
     * 解释: 注意你可以重复使用字典中的单词。
     */
    static List<String> res;
    static int max;
    static int sLenght;
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s .equals("") || wordDict.size() == 0)return new ArrayList<>();
        max = wordDict.get(0).length();
        for (int i = 1; i < wordDict.size(); i++) {
            if (wordDict.get(i).length() > max){
                max = wordDict.get(i).length();
            }
        }
        sLenght = s.length();
        res = new ArrayList<>();
        ArrayList<String> al = new ArrayList<>();
        dfs(al,0,s,0,wordDict);
        return res;
    }

    private static void dfs(List<String> al,int x,String s, int index ,List<String> wordDict) {
        boolean b =false;

        if (x >= al.size()){
            b =true;
            al.add("");
        }
        int size = al.size();
        String s1 = al.get(x);

        if (index == sLenght && wordDict.contains(s1)){
            if (b){
                al.remove(size -1);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size -1; i++) {
                sb.append(al.get(i));
                sb.append(" ");
            }
            sb.append(al.get(size -1));
            res.add(sb.toString());
            return;
        }

        if (s1.length() == max || index == sLenght){
            if (b){
                al.remove(size -1);
            }
            return;
        }
        s1 += s.charAt(index);
        al.set(x,s1);
        boolean b1 = false;
        if (wordDict.contains(s1)){
            b1= true;
            dfs(al,x,s,++index,wordDict);
            x++;
            index--;
        }
        dfs(al,x,s,++index,wordDict);
        if (s1.length() == 1){
            al.remove(size -1);
            return;
        }
        s1 = s1.substring(0, s1.length() -1);
        if (b1)x -= 1;
        al.set(x,s1);
    }

    public static void main1(String[] args) {
        /**
         * s = "pineapplepenapple"
         * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
         *s = "catsandog"
         * wordDict = ["cats", "dog", "sand", "and", "cat"]
         * "aaaaaaa"
         * ["aaaa","aa","a"]
         */
        List<String> strings = new ArrayList<>();
        strings.add("aaaa");
        strings.add("aa");
        strings.add("a");
//        strings.add("and");
//        strings.add("cat");
        System.out.println(wordBreak("aaaaaaa", strings));

    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (true){
            integers.add(1);
        }
    }
}
