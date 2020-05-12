package com.bite.b5_11;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/5/11 19:11
 */

public class PrintGrands {
    private  static List<Student> al;



    public static void main(String[] args) {

//        List<Integer> al1 = new ArrayList<>();
//        for (int i = 10; i >= 0; i--){
//            al1.add(i);
//        }
//        Collections.sort(al1);
//        System.out.println(al1);
//        print();



        String s = "welcome to bit";
        String s1 = "come";
        List<Character> al2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!s1.contains(c+"")){
                al2.add(c);
            }
        }
        System.out.println(al2);

    }

    private static void print(){
        al = new ArrayList<>();
        Student tjy = new Student("tjy", "1", 65);
        Student tmd = new Student("tmd", "1", 80);
        Student wz = new Student("wz", "1", 75);
        al.add(tjy);
        al.add(tmd);
        al.add(wz);
       for (Student s : al)
           System.out.println(s);

       System.out.println(al);
    }

}
