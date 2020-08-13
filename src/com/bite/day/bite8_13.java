package com.bite.day;

import javax.security.auth.login.CredentialException;
import java.lang.reflect.Array;
import java.util.*;

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

    public static void main1(String[] args) {
        System.out.println(Character.isDigit('5'));
        System.out.println(Math.pow(10,0));
        System.out.println(~0);
    }


    static ArrayList<ArrayList<Integer>> als = new ArrayList<>();
    public static boolean Game24Points (int[] arr) {
        // write code here
        if (arr.length != 4)return false;
        dfs(arr,0,new ArrayList<Integer>());
        for (ArrayList<Integer> al : als){
            System.out.println(al);
            for (int i = 0; i < al.size(); i++) {
                if (dfs(al,0,0))
                    return true;
            }
        }
        return false;

    }

    private static void dfs(int[] arr, int i,ArrayList<Integer> al) {
        if (i >= 4){
            als.add(new ArrayList<>(al));
            return;
        }
        for (int j = i; j <arr.length; j++) {
            al.add(arr[j]);
            dfs(arr,i+1,al);
            al.remove(al.size()-1);
        }
    }

    private static boolean dfs(ArrayList<Integer> al,int i,int sum){
        if (i == 3 && sum == 24)return true;
        if (i == 4)return false;
        if (i == 0){
            sum += al.get(0);
            dfs(al,i+1,sum);
        }

        return dfs(al,i+1,sum+al.get(i))||
        dfs(al,i+1,sum-al.get(i))||
        dfs(al,i+1,sum*al.get(i))||
        dfs(al,i+1,sum/al.get(i));
    }


    public static boolean IsValidExp (String s) {

        if (s.length() == 0)return true;
        // write code here
        HashMap<Character, Character> map = new HashMap<>();
        {
            map.put('}','{');
            map.put(')','(');
            map.put(']','[');

        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (stack.isEmpty())return false;
                Character pop = stack.pop();
                if (!pop.equals(map.get(s.charAt(i))))return false;
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    public int GetCoinCount (int N) {
        // write code here

        int n = 1024 - N;
        int sum = 0;
        sum += n / 64;
        n = n % 64;
        sum += n / 16;
        n %= 16;
        sum += n / 4;
        n %= 4;
        sum += n;
        return sum;

    }


    public static void main(String[] args) {
        int[] a = {7,2,1,10};
        System.out.println(Game24Points(a));
        System.out.println(IsValidExp("([)]"));
    }

}
