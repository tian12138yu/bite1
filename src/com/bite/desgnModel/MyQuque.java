package com.bite.desgnModel;

/**
 * @Author tjy
 * @Date 2020/5/13 19:34
 */


public class MyQuque {

    class Node{
        int val;
        Node next = null;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node fir;
    private Node last;
    int size = 0;

    public void offer(int val){
        Node node = new Node(val);
        if (last == null){
            fir = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Node peek(){
        if (isEmpty()){
            throw new RuntimeException("当前队列为空！");
        }
        return fir;

    }

    public Node poll(){
        if (isEmpty()){
            throw new RuntimeException("当前队列为空！");
        }
        Node node = fir;
        fir = fir.next;
        size--;
        return node;

    }

    public boolean isEmpty() {
        return size == 0;
    }

}
