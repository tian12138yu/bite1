package com.bite.card;

/**
 * @Author tjy
 * @Date 2020/5/11 20:49
 */

public class Card implements Comparable {

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

    @Override
    public int compareTo(Object o) {
        Card card = (Card)o;
        if (card.num > this.num)return -1;
        else if (this.num > card.num)return 1;
        else return 0;

    }
}
