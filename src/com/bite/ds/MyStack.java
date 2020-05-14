package com.bite.ds;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author tjy
 * @Date 2020/5/13 18:52
 */

public class MyStack<T> {

    private T[] elem;
    private int top;
    private int size;
    private  int len = 10;

    public MyStack() {
        this.elem = (T[])new Object[len];
        this.top = 0;
        this.size = 0;
    }

    public void push(T x){
        checkTop();
        this.elem[top] = x;
        top++;
        size++;

    }

    private void checkTop() {
        if (top >= elem.length){
            len *= 2;
            this.elem = Arrays.copyOf(elem, len);
        }
    }


    public T pop(){
        if (empty()){
            throw new RuntimeException("当前栈为空！");
        }
        T res = this.elem[top-1];
        top--;
        size--;
        return res;
    }


    public boolean empty() {
        return size == 0;
    }

}
