package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author tjy
 * @Date 2020/7/6 12:41
 */

public class bite7_6 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            String[] s1 = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (int i = s1.length - 1; i > 0; i--) {
                res.append(s1[i]);
                res.append(" ");
            }
            res.append(s1[0]);
            System.out.println(res.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        while ((s = br.readLine()) != null) {
            String[] s1 = s.split(" ");
            String s2 = s1[0].substring(s1[0].lastIndexOf("\\") + 1);
            s2 = s2 + " " + s1[1];
            if (map.containsKey(s2)) {
                map.put(s2, map.get(s2) + 1);
            } else {
                map.put(s2, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        //降序
        Collections.sort(list, (arg0, arg1) -> (arg1.getValue() - arg0.getValue()) == 0 ? (arg0.getValue() - arg1.getValue()) : (arg1.getValue() - arg0.getValue()));
        int count = 0;
        for (Map.Entry<String, Integer> mapping : list) {
            if (count < 8) {
                String[] s3 = mapping.getKey().split(" ");
                if (s3[0].length() > 16) {
                    s3[0] = s3[0].substring(s3[0].length() - 16);
                }
                System.out.println(s3[0] + " " + s3[1] + " " + mapping.getValue());
            }else break;
            count++;
        }
    }


    public static void main3 (String[] args) {
        System.out.println('\\');
    }

    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> map=new LinkedHashMap<String, Integer>();
        while(sc.hasNext()){
            String str=sc.next();
            int linenum=sc.nextInt();
            String[] arr=str.split("\\\\");  //根据\切割
            String s=arr[arr.length-1];
            if(s.length()>16)  //截取
                s=s.substring(s.length()-16);
            String key=s+" "+linenum;
            int value=1;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else {
                map.put(key, value);
            }
        }
        int count=0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+map.get(string));
        }
    }
}
