package com.bite;

/**
 * @Author tjy
 * @Date 2020/5/11 12:27
 */


/**
 * BBCABCDABABCDABCDABDE
 *
 * ABCDABD
 */
public class kmp {

    public static void main(String[] args){
        String s1 = "ABBXABBCDFS";
        String s2 = "ABCDABD";
        System.out.println(KMP(s1, s2));
    }

    public static int KMP(String ts, String ps){
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
//            如果t和p中位置匹配了，就让它们的下标都往下一位挪然后去比较，当然j又要回到开头时也要让他们的下标往下一位移
            if(j == -1 || t[i] == p[j]){
                i++;
                j++;
            }
//            否则，让当前j的位置知道自己要让前面的谁代替，next就是记录不匹配的时候哪个下标要去它那个位置的
            else{
                j = next[j];
            }
        }
//        如果j到它的字符数组长度了，说明在t找到了有与p完全相同的字串，i - j我们可以这样想
//        当j == p.length时 i == j  他们在同一个位置，我们要知道p的开头对在t的哪里的话就只需要 i - j
        if(j == p.length){
            return i - j;
        }
        else {
            return -1;
        }
    }

    public static int[] getNext(String ps){
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < p.length - 1) {
            if(k == -1 || p[j] == p[k]){
//            k   j
//                A   A   A   C   A   A
//               -1   ?   ?
//               当两个字符相等时要跳过
                if (p[++j] == p[++k]) {
                    next[j] = next[k];
                }
//            k   j
//                A   B   C
//               -1   ?   ?
//                这里不相等k也会++ ， j也是
                else {
                    next[j] = k;
                }
            }
            else{
                k = next[k];
            }
        }
//        打印数组看一下
        System.out.println("next数组：");
        for(int i:next){
            System.out.print(i + " ");
        }
        System.out.println();

        return next;
    }

//    public static int[] getNext1(String ps){
//        char[] chars = ps.toCharArray();
//        int[] next = new int[chars.length];
//        next[0] = -1;
//
//
//
//        return null;
//
//    }
}