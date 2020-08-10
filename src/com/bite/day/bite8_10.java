package com.bite.day;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/8/10 10:01
 */

public class bite8_10 {
    public int NumberOf1Between1AndN_Solution(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int count = 0;
        for (int i = 1; i <= len; i++) {
            int x = s.charAt(len - i) - '0';
            if (x > 1){

            }
        }
        return 0;
    }

    public int NumberOf1Between1AndN_Solution1(int n) {
        if(n <= 0)return 0;
        int count = 0;
        for(int i=1; i <= n; i*=10){
            //计算在第i位上总共有多少个1
            count = count + (n/(10*i))*i;
            //不足i的部分有可能存在1
            int mod = n%(10*i);
            //如果超出2*i -1，则多出的1的个数是固定的
            if(mod > 2*i -1)count+=i;
            else{
                //只有大于i的时候才能会存在1
                if(mod >= i)
                    count += (mod -i)+1;
            }
        }
        return count;

    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int count = array[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (count < 0){
                count = array[i];
            }else {
                count += array[i];
            }
            max = Math.max(count,max);
        }
        return max;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode root = new RandomListNode(pHead.label);
        RandomListNode cur = root;
        root.random = pHead.random;
        map.put(pHead,root);
        pHead = pHead.next;
        while (pHead != null){
            RandomListNode node = new RandomListNode(pHead.label);
            cur.next = node;
            cur = cur.next;
            node.random = pHead.random;
            map.put(pHead,node);
            pHead = pHead.next;
        }

        cur = root;
        while (cur != null){
            cur.random = map.get(cur.random);
            cur = cur.next;
        }
        return root;
    }

    public static String PrintMinNumber(int [] numbers) {
        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(s, (o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }

    public String PrintMinNumber2(int [] numbers) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                String str1=o1+""+o2;
                String str2=o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb=new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {3,32321};
        System.out.println(PrintMinNumber(a));
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
