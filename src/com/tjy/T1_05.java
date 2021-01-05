package com.tjy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2021/1/5 19:42
 */

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 */

public class T1_05 {


    public static List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        int max = 3;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int x = i,y;
            while (i + 1 < chars.length && chars[i] == chars[i+1]) {
                i++;
            }
            y = i;
             if (y - x + 1 >= max) {
                List<Integer> al1 = new ArrayList<>();
                al1.add(x);
                al1.add(y);
                al.add(al1);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = largeGroupPositions("abcdddeeeeaabbbcd");
        for (List<Integer> al : lists) {
            System.out.println(al);
        }
    }
}
