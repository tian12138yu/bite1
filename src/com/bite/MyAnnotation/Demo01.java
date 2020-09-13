package com.bite.MyAnnotation;

import java.lang.annotation.*;

/**
 * @Author tjy
 * @Date 2020/9/13 21:11
 */

public class Demo01 {

}


@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}
