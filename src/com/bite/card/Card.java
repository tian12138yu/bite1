package com.bite.card;

/**
 * @Author tjy
 * @Date 2020/5/11 20:49
 */

public class Card {

    int num;
    String type;

    public Card(int num, String type) {
        this.num = num;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", type, num);
    }
}
