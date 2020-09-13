package com.bite.day.september;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/9/13 9:37
 */

public class bite9_13 {

    /**
     *给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     *
     *  
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     */
    static boolean[][] b ;
    public static boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        b = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == c)
                    if (dfs(board,j,i,word,"",0))
                        return true;
            }
        }
        return false;

    }

    private static boolean dfs(char[][] board, int i, int j, String word,String temp,int x) {
        if (i < 0 || i >= board.length || j < 0 ||j >= board[0].length ||
                x > word.length() || b[i][j])return false;
        if (word.charAt(x) != board[i][j])return false;
        temp += board[i][j];
        if (temp.equals(word))return true;
        b[i][j] = true;
        boolean b1 = dfs(board, i + 1, j, word, temp, x + 1) ||
                dfs(board, i, j + 1, word, temp, x + 1) ||
                dfs(board, i - 1, j, word, temp, x + 1) ||
                dfs(board, i, j - 1, word, temp, x + 1);
        b[i][j] = false;
        return b1;
    }

    public static void main1(String[] args) throws IOException {
        char[][] c= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s ="ABCB";
        System.out.println(exist(c, s));
        FileWriter fileWriter = new FileWriter("");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            String ss = br.readLine();
            int temp = 0;
            StringBuilder res = new StringBuilder();
            while (temp < ss.length()){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n && temp < ss.length(); i++) {
                    sb.append(ss.charAt(temp));
                    temp++;
                }
                res.append(sb.reverse());
            }
            System.out.println(res.toString());
        }
    }


}

