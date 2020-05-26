package com.bite;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/5/26 19:04
 */

public class bite5_28 {

    static class Generic< T extends Comparable<T> > {
        private T[] x;
        public  Generic() {
            x = (T[]) new Object();
        }

        public static  <T> T max(T[] t){
            Arrays.sort(t);

            return t[t.length - 1];
        }
    }

    /**
     * 1、找出10W个数据当中，第一个重复的元素。
     * @param args
     */
    public static void main1(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            int x = random.nextInt(6000);
            if (list.contains(x)){
                System.out.println(x);
                return;
            }
            list.add(x);
        }
    }

    /**
     * 3、10万个数据，统计重复数字及出现的次数
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : list) {
            if (map.containsKey(x)){
                map.put(x,map.get(x) + 1);
            }else {
                map.put(x,1);
            }
        }
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                set.remove(x);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}
