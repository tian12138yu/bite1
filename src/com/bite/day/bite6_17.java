package com.bite.day;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/17 13:03
 */

public class bite6_17 {

    public void a (){

    }

    public void b(){
        this.a();
        a();
    }

    public static int addAB(int A, int B) {
        // write code here
        String s1 = String.valueOf(A);
        String s2 = String.valueOf(B);

        int len1 = s1.length();
        int len2 = s2.length();
        int len = Math.min(len1,len2);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int pre = 0;
        while (i <= len){
            int x = s1.charAt(len1 - i) + s2.charAt(len2 - i) - 48*2 + pre;
            pre = x / 10;
            x = x % 10;
            sb.append(x);
            i++;
        }
        String s ;
        if (len1 > len2){
            s = s1;
            len = len1;
        }else {
            s = s2;
            len = len2;
        }
        while (i <= len){
            int x = s.charAt(len - i)- 48 + pre;
            pre = x /10;
            x = x %10;
            sb.append(x);
            i++;
        }
        if (pre == 1){
            sb.append("1");
        }

        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main1(String[] args) {
        System.out.println(addAB(1, 2));
    }


    /**
     *求一个变化的数是否可以被某个数除的开，可以取每次模的值继续变化，跟不取模是同一个结果。
     * @param args
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;

        }
        int res = (count + 2) / 3;
        System.out.println(res > 100000 ? -1 : res);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        while (x0 != 0 ) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;
        }
        System.out.println(x0);
        System.out.println(count);
    }
}
