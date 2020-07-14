package com.bite.day;

/**
 * @Author tjy
 * @Date 2020/7/14 13:15
 */

public class bite7_14 {
    /**
     *            1
     *       2           3
     *     4   5      6     7
     *   8 9 10 11 12 13 14 15
     *
     */
    public static int getLCA(int a, int b) {
        // write code here
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        while (max != min){
            max = max >>>1;
            if (max < min){
                int temp = max;
                max = min;
                min = temp;
            }
        }
        return max;

    }

    public static String replaceSpace(String iniString, int length) {
        // write code here
//         return iniString.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(iniString.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getLCA(9, 5));
        System.out.println(replaceSpace("Mr John Smith", 13));
    }
}
