package com.bite;

import javax.xml.namespace.QName;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/3 14:26
 */

public class bite6_3 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String res = "";
//        StringBuilder s1 = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c < 58 && c > 47){
//                s1.append(c);
//                if (s1.length() > res.length()){
//                    res = s1.toString();
//                }
//            }else {
//                s1 = new StringBuilder();
//            }
//        }
//        System.out.println(res);
        System.out.println(chkParenthesis("()(())", 6));

    }

    public static boolean chkParenthesis(String A, int n) {
        // write code here

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c != '(' &&  c != ')'){
                return false;
            }
            if (c == '('){
                stack.push(c);
            }
            else {
                if (stack.isEmpty())return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty())return false;
        return true;

    }



}
















