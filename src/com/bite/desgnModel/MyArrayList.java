package com.bite.desgnModel;

import java.util.Arrays;

/**
 * @Author tjy
 * @Date 2020/5/13 15:09
 */

public class MyArrayList<T> {
    public T[] elem;//数组
    public int usedSize;//有效的数据个数
    public static final int intCapacity = 10;//初始容量

    public MyArrayList() {
        this.elem = (T[])new Object[intCapacity];
        this.usedSize = 0;
    }

    public boolean add(T i,int pos){
        if (pos < 0||pos > usedSize)return false;

        for (int x = usedSize; x > pos; x--){
            elem[x] = elem[x-1];
        }
        elem[pos] = i;
        usedSize++;
        return true;
    }

    public void delete(int index){
        checkIndex(index);
        for (int x = index+1; x < usedSize; x++){
            this.elem[x-1]=this.elem[x];
        }
    }

    public void update(int index,T x){
        checkIndex(index);
        this.elem[index] = x;
    }

    private boolean checkIndex(int index){
        if (index < 0 || index >= usedSize){
            throw new RuntimeException("角标错误！");
        }
        return true;

    }

    public T getPos(int pos){
        if (usedSize == 0 ||
                pos >= usedSize ||
                pos < 0)throw new RuntimeException("dada");
        return elem[pos];
    }

    public int size(){
        return usedSize;
    }

    public String toString(){
        return Arrays.toString(elem);
    }

    public int search(T toFind){
        for (int x = 0; x < usedSize; x++){
            if (elem[x] == toFind ){
                return x;
            }
        }
        return -1;
    }

    public boolean contains(T toFind){
        for (int x = 0; x < usedSize; x++){
            if (elem[x] == toFind ){
                return true;
            }
        }
        return false;
    }

}
