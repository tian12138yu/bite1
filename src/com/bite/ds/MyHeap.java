package com.bite.ds;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/21 18:49
 */

public class MyHeap {



    public int[] elem;
    public int usedSize;

    public MyHeap() {
        this.elem = new int[10];
    }

    /**
     *
     * @param root 每棵子树的开始位置
     * @param len  结束位置
     */
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //0、判断是否有左右孩子  有的话 找到最大值 C下标表示最大值下标
            if(child + 1 < len) {
                child = this.elem[child] > this.elem[child + 1] ? child : child + 1;
            }
            //代码指向到这里，c表示最大值下标
            if(this.elem[child] > this.elem[parent]) {
                //交换
                int temp = elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }

    }

    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //i：每棵子树的根节点下标
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }


    }

    public void push(int val) {
        //0、堆是否是满的--》扩容
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        //1、放到数组的最后一个位置
        this.elem[usedSize++] = val;
        //2、进行调整
        adjustUp(usedSize - 1);
    }

    public void pop(){
        if (isEmpty())return;
        int temp = this.elem[0];
        this.elem[0] =  this.elem[usedSize - 1];
        this.elem[usedSize - 1] = temp;
        usedSize--;
        adjustDown(0,usedSize);
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void adjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]){
                int temp = elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                child = parent;
                parent = (parent -1) / 2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {

        return usedSize == elem.length;
    }

    public void sort(){
        int end = this.usedSize - 1;
        while (end > 0){
            int temp = this.elem[0];
            this.elem[0] =  this.elem[end - 1];
            this.elem[end - 1] = temp;
            adjustDown(0,end);
            end--;
        }

    }



}
