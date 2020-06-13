package com.bite.day;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/6/13 13:12
 */

public class bite6_13 {
    public void x(int a,double b){

    }

    public void x(double b,int a){

    }

    public static int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0]^AB[1];
        AB[1] = AB[0]^AB[1];
        AB[0] = AB[0]^AB[1];
        return AB;
    }

    public class GrayCode {
        public String[] getGray(int n) {
            int m = 1<<n;
            String[] r = new String[m];
            if(n==1){
                r[0] = "0";
                r[1] = "1";
                return r;
            }
            String[] temp = getGray(n-1);
            int j = 0;
            for(int i = 0;i<m;i++){
                if(i<m/2){
                    r[i] = "0"+temp[j++];
                }else{
                    r[i] = "1"+temp[--j];
                }
            }
            return r;
        }
    }

    public static void main(String[] args) {
        int[] a ={1,2};
        int[] ints = exchangeAB(a);
        System.out.println(Arrays.toString(ints));
    }
}



