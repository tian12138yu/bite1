package com.bite.day;

/**
 * @Author tjy
 * @Date 2020/5/12 14:47
 */

public class bite5_12 {
    public static void main(String[] args) {
        A<Integer> a =new A(5);
        System.out.println(a.get());
    }

    static class A<T> {
        T value;

        A(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }
}
