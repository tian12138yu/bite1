package com.bite.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/29 14:13
 */

public class bite6_29 {
    static int[] rate = {100,89,84,81,77,74,71,67,63,59,0};
    static HashMap<Integer,Double> map = new HashMap<>();
    static {
        map.put(0,4.0);
        map.put(1,3.7);
        map.put(2,3.3);
        map.put(3,3.0);
        map.put(4,2.7);
        map.put(5,2.3);
        map.put(6,2.0);
        map.put(7,1.5);
        map.put(8,1.0);
        map.put(9,0.0);
    }
    public static void main1(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] credit = new int[n];
            int count = 0;
            double gpas = 0;
            for (int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
                count += credit[i];
            }
            for (int i = 0; i < n; i++) {
                int x  = sc.nextInt();
                double gpa;
                int j = 0;
                for (; j < 11; j++) {
                    if (x > rate[j])break;
                }

                gpa = map.get(j-1);
                gpa *= credit[i];
                gpas += gpa;

            }
            gpas /= count;
            System.out.printf("%.2f",gpas);
        }
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s=bf.readLine())!=null){
            int n=Integer.parseInt(s);
            String[] s1 = bf.readLine().split(" ");
            int[] credit = new int[n];
            int count = 0;
            float gpas = 0;
            for (int i = 0; i < s1.length; i++) {
                credit[i]=Integer.parseInt(s1[i]);
                count += credit[i];
            }
            String[] s2 = bf.readLine().split(" ");
            for (int i = 0; i < s2.length; i++) {
                int x =Integer.parseInt(s2[i]);
                double gpa;
                int j = 0;
                for (; j < 11; j++) {
                    if (x > rate[j])break;
                }

                gpa = map.get(j-1);
                gpa *= credit[i];
                gpas += gpa;
            }
            gpas /= count;
            System.out.printf("%.2f",gpas);
        }
    }

    /**
     * 壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整
     */
    static char[] cs = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖','拾'};
    static HashMap<Integer,String> map2 = new HashMap<>();
    static {
        map2.put(-1,"角");
        map2.put(-2,"分");
        map2.put(1,"元");
        map2.put(2,"拾");
        map2.put(3,"佰");
        map2.put(4,"仟");
        map2.put(5,"万");
        map2.put(6,"拾");
        map2.put(7,"佰");
        map2.put(8,"仟");
        map2.put(9,"亿");
        map2.put(10,"拾");
        map2.put(11,"佰");
        map2.put(12,"仟");

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] split = s.split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append("人命币");
            boolean isZero = false;
            for (int i = 0; i < split[0].length(); i++) {
                char c = split[0].charAt(i);
                if (c == '0'){
                    isZero = true;
                    continue;
                }else {
                    if (isZero){
                        sb.append(cs[0]);
                    }
                    String s1 = map2.get(split[0].length() - i);
                    if (s1.equals("拾")){
                        if (cs[c - 48] == '壹'){
                            sb.append(s1);
                            continue;
                        }
                    }
                    sb.append(cs[c - 48]);
                    sb.append(s1);
                }
            }
            if (split[1].charAt(0) == '0' && split[1].charAt(1) == '0'){
                sb.append('整');
            }else {
                for (int i = 0; i < 2; i++) {
                    char c = split[1].charAt(i);
                    if (c != '0'){
                        sb.append(cs[c - 48]);
                        sb.append(map2.get(-(i+1)));
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
