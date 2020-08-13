package com.bite.day;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/8/13 10:18
 */

public class bite8_13 {

    public String ReverseSentence(String str) {
        if (str.length() == 0 || str.equals("   "))return str;
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i > 0; i--) {
            sb.append(s[i]);
            sb.append(" ");
        }
        sb.append(s[0]);
        return sb.toString();
    }

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0)return false;
        Arrays.sort(numbers);
        int x = 0;
        int sum = 0;
        while (numbers[x] == 0){
            sum++;
            x++;
        }

        int qian = 0;
        for (int i = x+1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i-1])return false;
            if (numbers[i] - numbers[i-1] != 1){
                qian += numbers[i] - numbers[i-1] - 1;
            }
        }


        return sum >= qian;
    }

    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        if (m > n)m = m % n;
        int i = -1,step = 0, count = n;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环。
            if(array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }



    public int StrToInt(String str) {
        if (str.length() == 0)return 0;
        char[] chars = str.toCharArray();
        int j = 0;
        if (chars[0] == '+' || chars[0] == '-')j = 1;
        int pow = 0;
        int res = 0;
        for (int i = chars.length - 1; i >= j; i--) {
            if (!Character.isDigit(chars[i]))return 0;
            res += (chars[i] - '0') * Math.pow(10,pow);
            pow++;
        }
        if (chars[0] == '-') res = ~res + 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Character.isDigit('5'));
        System.out.println(Math.pow(10,0));
        System.out.println(~0);
    }

}
