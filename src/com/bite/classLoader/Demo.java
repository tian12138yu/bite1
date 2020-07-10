package com.bite.classLoader;

import java.util.HashMap;

/**
 * @Author tjy
 * @Date 2020/7/9 13:41
 */

public class Demo {
    public static void main(String[] args) {

        ClassLoader classLoader = Demo.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
