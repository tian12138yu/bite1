package com.bite.ds;

import java.util.Stack;

/**
 * @Author tjy
 * @Date 2020/5/14 19:56
 */

public class TwoStackOfQueue {

    private  Stack<Integer> s1;
    private  Stack<Integer> s2;

    public TwoStackOfQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public Integer pop(){
        if (isEmpty())return -1;
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public Integer peek(){
        if (isEmpty())return -1;
        if (s2.empty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public void offer(int val){
        s1.push(val);
    }



    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }


}
