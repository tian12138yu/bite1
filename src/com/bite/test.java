package com.bite;

import com.bite.ds.MyHashMap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author tjy
 * @Date 2020/6/1 15:45
 */

class Person{
    public int id;

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

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 7; i++) {
            myHashMap.put(new Person(i),i);
        }
        myHashMap.put(new Person(11),11);
        int o = (int) myHashMap.get(new Person(3));
        System.out.println(o);
        HashMap<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put(new Person(i),i);
        }
        Integer integer = map.get(new Person(3));
        System.out.println(integer);
    }
}
