package com.bite.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tjy
 * @Date 2020/5/14 18:58
 */

public class TwoListOfStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public TwoListOfStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int val){
        Queue queue = queue1.isEmpty() ? queue1 : queue2;
        queue.add(val);
    }

    public Integer pop(){
        Queue queue = queue1.isEmpty() ? queue1 : queue2;//空的
        Queue queues = queue1.isEmpty() ? queue2 : queue1;//不为空的
        if (queues.isEmpty())throw new RuntimeException("当前栈为空！");
        while (queues.size() != 1){
            queue.add(queues.poll());
        }
        return (Integer) queues.poll();
    }

    public Integer top(){
        Queue queue = queue1.isEmpty() ? queue1 : queue2;//空的
        Queue queues = queue1.isEmpty() ? queue2 : queue1;//不为空的
        if (queues.isEmpty())throw new RuntimeException("当前栈为空！");
        Integer res = 0;
        while (queues.isEmpty()){
             res = (Integer) queues.poll();
            queue.add(res);
        }
        return res;
    }


    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }


}
