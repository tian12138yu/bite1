package com.bite.proxy;

/**
 * @Author tjy
 * @Date 2020/8/7 15:02
 */

public class UserImpl implements User{
    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public int update(int id) {
        return id;
    }
}
