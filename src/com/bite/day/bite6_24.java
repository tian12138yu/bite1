package com.bite.day;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/25 9:55
 */

public class bite6_24 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int res = getTotalCount(n);
            System.out.println(res);
        }

    }

    private static int getTotalCount(int mounth) {

        if(mounth == 1 || mounth == 2){
            return 1;
        }
        int tempold = 1;
        int tempyoung = 1;
        int mounth1 = 1;
        int mounth2 = 0;
        for(int j = 4; j <= mounth; j++){
            //第一步，第二个月的变成了有生育能力的兔子
            tempold += mounth2;
            //第二步，一个月大的兔子变成了两个月大的兔子
            mounth2 = mounth1;
            //第三步，有生育能力的兔子生出了一个月大的小兔子
            mounth1 = tempold;
            //当月小兔子的个数
            tempyoung = mounth1 + mounth2;

        }
        return tempold + tempyoung;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' '){
                    sb.append(c);
                    continue;
                }
                int x = c - 5 -65;
                if (x < 0){
                    c = (char) ('Z' + x + 1);
                }else {
                    c = (char) (c - 5);
                }
                sb.append(c);

            }
            System.out.println(sb.toString());
        }
    }



}
