package com.bite;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/6/1 15:45
 */

class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class test {

    public static void main1(String[] args) {
//        MyHashMap myHashMap = new MyHashMap();
//        for (int i = 0; i < 7; i++) {
//            myHashMap.put(new Person(i),i);
//        }
//        myHashMap.put(new Person(11),11);
//        int o = (int) myHashMap.get(new Person(3));
//        System.out.println(o);
//        HashMap<Person, Integer> map = new HashMap<>();
//        for (int i = 0; i < 7; i++) {
//            map.put(new Person(i),i);
//        }
//        Integer integer = map.get(new Person(3));
//        System.out.println(integer);
//        StringBuilder a = new StringBuilder("a");
//        a.insert(1,"b");
//        System.out.println(a.toString());
        Person person = new Person(122);
        Integer[] a = {2,5,6,32,4,2};
        List<Integer> ints = Arrays.asList(a);
        /**
         * Arrays.aslist使用：数组必须为包装类
         * 如果是基本数据类型则返回值的泛型为基本数据数组类型不是基本数据类型。
         */
        String[] userid = {"aa","bb","cc"};
        List<String> userList = Arrays.asList(userid);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        int count1 = 1;
        int count2 = 1;
        while (count1 + count2 <= n){
            int temp = count1;
            count1 = count2;
            count2 = temp + count2;
        }
        if (count1 + count2 == n){
            System.out.println(0);
        }
        System.out.println(Math.min(n - count2, count1 + count2 - n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()){
            sb.append(sc.nextLine()+ " ");
        }
        String[] s = sb.toString().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            set.add(s[i]);
        }
        System.out.println(set.size());
    }

}

















