package com.bite.bookStore.user;

/**
 * @Author tjy
 * @Date 2020/5/1 15:33
 */

public abstract class User {

    String name;
    String password;
    int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User(String name, String password, int type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }
    public abstract void menue();
}
