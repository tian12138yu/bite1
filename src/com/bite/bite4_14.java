package com.bite;

import java.util.Arrays;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/4/14 16:17
 */

public class bite4_14 {
    public static void main(String[] args) {
        int sum = sum(3, 8);
        double sum1 = sum(3.5, 6.4, 5.5);
        System.out.println(sum+" "+sum1);
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
        int res=0;int one=1;int two=2;
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

}
