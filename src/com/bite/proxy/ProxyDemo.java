package com.bite.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author tjy
 * @Date 2020/8/7 15:02
 */

public class ProxyDemo {
    public static void main(String[] args) {

        Class[] classes = {User.class};
        User user = (User)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), classes, new MyHandler(new UserImpl()));
        user.add(2, 3);



    }



}

class MyHandler implements InvocationHandler{

    Object obj;

    public MyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法增强前！" +method.getName());

        Object invoke = method.invoke(obj,args);

        System.out.println("方法增强后！");

        return invoke;
    }
}
