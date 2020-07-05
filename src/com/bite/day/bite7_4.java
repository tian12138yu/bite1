package com.bite.day;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/7/5 13:53
 */

public class bite7_4 {
    /**
     * 1、1、1、0、0、1、0、1
     * 3 0000 0011
     * 3a
     * 10110011
     * 10110011
     *
     * @param args
     */


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            char[] array = s.toCharArray();
            for (char c : array) {
                String s1 = Integer.toBinaryString(c);
                int i = c;
                int count = 0;
                while (i != 0){
                    i = i & i-1;
                    count++;
                }
                String res = String.format("%07d", Integer.parseInt(s1));
                System.out.println(count % 2 == 0 ? "1" + res : "0" + res);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = br.readLine();
            }
            Arrays.sort(ss, (o1, o2) -> {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 != len2){
                    return len1 - len2;
                }
                else {
                    return o1.compareTo(o2);
                }
            });

            for (int i = 0; i < n; i++) {
                System.out.println(ss[i]);
            }
        }
    }

    public static void main2(String[] args) {
//        System.out.println(String.format("%07d", Integer.parseInt("110011")));
        String[] s = {"3","5","6",
                "11111111111111111111111111111",
                "2222222222222222222222222222222222",
                "33333333"};
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int min = Math.min(len1,len2);
                if (len1 != len2){
                    return len1 - len2;
                }
                else {
                    int k  = 0;
                    while (k < min){
                        char c = o1.charAt(k);
                        char c1 = o2.charAt(k);
                        if (c != c1){
                            return c - c1;
                        }
                    }
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(s));
    }
}
