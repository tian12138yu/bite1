package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author tjy
 * @Date 2020/7/7 15:05
 */

public class bite7_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine())!= null){
            String[] s1 = s.split(" ");
            String[] split = s1[0].split("\\.");
            String[] split1 = s1[1].split("\\.");
            int x = 2;
            int[] map = {0,17,29};
            boolean jiewei = false;
            StringBuilder sb = new StringBuilder();
            while (x >= 0){
                int i = Integer.parseInt(split1[x]) - Integer.parseInt(split[x]);
                if (jiewei) i = i  -1;
                if (i < 0){
                    i = i + map[x];
                    jiewei = true;


                }else {
                    jiewei = false;
                }
                sb.insert(0,i);
                if (x != 0 )sb.insert(0,".");
                x--;
            }
            if (jiewei){
                x = 2;
                jiewei = false;
                sb = new StringBuilder();
                while (x >= 0){
                    int i = Integer.parseInt(split[x]) - Integer.parseInt(split1[x]);
                    if (jiewei) i = i  -1;
                    if (i < 0){
                        i = i + map[x];
                        jiewei = true;


                    }else {
                        jiewei = false;
                    }
                    sb.insert(0,i);
                    if (x != 0 )sb.insert(0,".");
                    x--;
                }
                System.out.print("-");
            }

            System.out.println(sb.toString());
        }
    }

    public int countNumberOf2s(int n) {
        int result = 0;
        for(int i = 1;i <= n;i *= 10)
        {
            result += (n/i+7) / 10 * i + (n/i%10 == 2?n%i+1:0)  ;
        }
        return result;


    }

}
