package com.bite.day;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/17 11:06
 */

public class bite7_17 {

    /**
     * 求连续最大和
     * 输入：3 -1 2 1
     * 输出：3
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String s1 = br.readLine();
            String[] s2 = s1.split(" ");
            int res = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < s2.length; i++) {
                if (sum > 0){
                    sum += Integer.parseInt(s2[i]);
                }else {
                    sum = Integer.parseInt(s2[i]);
                }
                res = Math.max(sum,res);
            }
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] split = s.split(";");
            int x = 0,y = 0;
            for (String s1 : split){
                if (s1.length() <= 1 || s1.length() > 3)continue;
                boolean b = true;
                String substring = s1.substring(1);
                try {
                    Integer.parseInt(substring);
                }catch (Exception e){
                    b = false;
                }

                if (b){
                    int num = Integer.parseInt(substring);
                    switch (s1.charAt(0)){
                        case 'A': x -= num;break;
                        case 'D': x += num;break;
                        case 'W': y += num;break;
                        case 'S': y -= num;break;
                        default:break;
                    }
                }

            }
            System.out.println(x + "," + y);
        }


    }
}
