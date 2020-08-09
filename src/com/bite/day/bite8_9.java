package com.bite.day;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author tjy
 * @Date 2020/8/9 9:45
 */

public class bite8_9 {

    /**
     * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
     *
     * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
     *
     * 示例:
     * 输入: sx = 1, sy = 1, tx = 3, ty = 5
     * 输出: True
     * 解释:
     * 可以通过以下一系列转换从起点转换到终点：
     * (1, 1) -> (1, 2)
     * (1, 2) -> (3, 2)
     * (3, 2) -> (3, 5)
     *
     * 输入: sx = 1, sy = 1, tx = 2, ty = 2
     * 输出: False
     *
     * 输入: sx = 1, sy = 1, tx = 1, ty = 1
     * 输出: True
     */

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (tx > 0 && ty > 0){//因为sx, sy, tx, ty 是范围在 [1, 10^9] 的整数，逆推不能出界
            if (sx == tx && sy == ty){//判断是否到达了起始值
                return true;
            }

            if (tx > ty){
                tx -= Math.max((tx - sx) / ty, 1) * ty;
            }else {
                ty -= Math.max((ty - sy) / tx, 1) * tx;
            }
        }
        return false;
    }

    public static void main1(String[] args) {
        System.out.println(reachingPoints(9,5,12,8));
    }

    public static void main(String[] args) {
//        split(12);
//        String s ;
//



    }
    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0) System.out.print(split((number + 1) / 2));
            System.out.print(split(number / 2));
        }
        return number;
    }

    static class a{
        private int x = 2;
    }

    static class b extends a{

    }
}
