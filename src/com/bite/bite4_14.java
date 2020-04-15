package com.bite;

import java.util.Arrays;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/4/14 16:17
 */

public class bite4_14 {
    public static void main(String[] args) {
//        int sum = sum(3, 8);
//        double sum1 = sum(3.5, 6.4, 5.5);
//        System.out.println(sum+" "+sum1);
//        int diguisum = diguisum(156);
//        System.out.println(diguisum);
        String printsum = printsum(158);
        System.out.println(printsum);
    }
    /**
     * 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
     */
    public static int findOne(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    /**
     * 求斐波那契数列的第n项。(迭代实现)
     */
    public static int fei(int n){
        int res=0;int one=1;int two=1;
        for (int x = 3;x <= n; x++){
            res=one+two;
            one=two;
            two=res;
        }
        return res;
    }

    /**
     *求1！+2！+3！+4！+........+n!的和
     */
    public static int jiecheng(int n){
        int res=0;
        for (int i = 1; i < n; i++){
            res+=jie(i);
        }
        return res;
    }

    private static int jie(int i) {
        int res=1;
        for (int x = 2; x <=i; x++ ){
            res*=x;
        }
        return res;
    }

    /**
     * 创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
     *
     * ​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
     */

    public static int max2(int x,int y){
        return x>y?x:y;
    }
    private static int max3(int x,int y,int z){
        return max2(z,max2(x,y));

    }

    /**
     * 在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
     */

    public static int max(int x,int y){
        return x>y?x:y;
    }
    public static double max(double x,double y){
        return x>y?x:y;
    }
    public static double max(int x,int y,double z){
        return max(z,(double)max(x,y));
    }

    /**
     * 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
     */

    public static int sum(int x,int y){
        return x+y;
    }
    public static double sum(double x,double y,double z){
        return x+y+z;
    }

    /**
     * 青蛙跳台阶问题
     */

    public static int jump(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        return jump(n-1)+jump(n-2);
    }

    /**
     * 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
     */

    public void jiouhuan(List<Integer> al){
        for (int x = 0;x < al.size(); x++){
            if(al.get(x)%2==0){
                int y=al.get(x);
                al.remove(x);
                al.add(y);
            }
        }

    }

    /**
     * 递归求斐波那契数列的第 N 项
     */

    public static int feibudigui(int n){
        if(n==1||n==2)return 1;
        return feibudigui(n-1)+feibudigui(n-2);
    }

    /**
     * 写一个递归方法，输入一个非负整数，返回组成它的数字之和
     */


    public static int diguisum(int n){
        if(n/10==0)return n;
        return diguisum(n/10)+n%10;
    }

    /**
     * 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
     */
    public static String printsum(int n){
        if(n/10==0)return String.valueOf(n);
        return printsum(n/10)+" "+n%10;
    }

    /**
     * 递归求 1 + 2 + 3 + ... + 10
     */

    public static int tensum(int n){
        if(n==1)return 1;
        return tensum(n-1)+n;
    }

    /**
     * 递归求 N 的阶乘
     */

    public static int njiecheng(int n){
        if(n==1)return 1;
        return n*njiecheng(n-1);
    }

    /**
     * 实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
     */

    public static double avg(int[] sums){
        int sum=0;
        for (int x=0;x < sums.length; x++){
            sum+=sums[x];
        }
        return (double) sum/sums.length;
    }

    /**
     * 实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
     */

    public static int sum(int[] sums){
        int sum=0;
        for (int x=0;x < sums.length; x++){
            sum+=sums[x];
        }
        return  sum;
    }

    /**
     * 实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
     * 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
     */

    public static int[] transform(int[] sums){
        for (int x=0;x < sums.length; x++){
            sums[x]*=2;
        }
        return sums;
    }

    /**
     * 实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
     */

    public static void printArray(int[] sums){
        System.out.print("[ ");
        for (int x=0;x < sums.length; x++){
            System.out.print(sums[x]+" ");
        }
        System.out.println("]");
    }

    /**
     * 创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
     */
    public static int[] array(){
        int[] array=new int[100];
        for (int x = 0;x < 100; x++){
            array[x] =x+1;
        }
        return array;
    }


}
