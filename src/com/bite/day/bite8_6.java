package com.bite.day;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/8/6 10:10
 */

public class bite8_6 {

    public static int minimumLengthEncoding(String[] words) {
        if (words.length == 0)return 0;
        Arrays.sort(words,(o1, o2) ->
            o2.length() -o1.length()
        );
        int length = words[0].length()+1;
        boolean b;
        for (int i = 1; i < words.length; i++) {
            b =false;
            for (int j = 0; j < i; j++) {
                if (words[j].endsWith(words[i])){
                    b =true;
                    break;
                }
            }
            if (!b){
                length += words[i].length()+1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String[] ss = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(ss));
        String s = "";
        String[] split = s.split(",");
        System.out.println(split[0]);
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        char val;

        public TrieNode(char val) {
            this.val = val;
        }

        public TrieNode() {
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        if (word == null)return;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
    }
}
