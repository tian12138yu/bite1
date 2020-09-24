package com.bite.MyAnnotation;

import java.lang.annotation.*;

/**
 * @Author tjy
 * @Date 2020/9/13 21:11
 */
@MyAnnotation
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(-0.0 == 0.0);
    }
}


@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}
