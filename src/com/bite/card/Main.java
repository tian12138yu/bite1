package com.bite.card;

import java.util.*;

/**
 * @Author tjy
 * @Date 2020/5/11 20:50
 */

public class Main {


    private static final String[] TYPES = {"♥","♠","♦","♣"};

    private static List<Card> al;

    private static List<Card> init(){
        al = new ArrayList<>();
        for (int i = 1; i <= 13 ; i++) {
            for (int j = 0; j <4 ; j++) {
                al.add(new Card(i,TYPES[j]));
            }
        }
        return al;
    }

    private static void rush(){
        Random random = new Random();
        for (int i = al.size()-1; i > 0 ; i--) {
            int i1 = random.nextInt(i);
            Card card =al.get(i);
            al.set(i,al.get(i1));
            al.set(i1,card);
        }
    }

    /**
     * 三人斗地主，三人轮流揭牌，知道接完为止。
     */
    private static void display(){
        List<Card> al1 = new ArrayList<>();
        List<Card> al2 = new ArrayList<>();
        List<Card> al3 = new ArrayList<>();
        List<Card> temp = al1;
        while (!al.isEmpty()){
            Card card = al.get(0);
            al.remove(0);
            temp.add(card);
            if (temp == al1){
                temp = al2;
            }else if (temp == al2){
                temp = al3;
            }else {
                temp = al1;
            }
        }
        Collections.sort(al1);
        Collections.sort(al2);
        Collections.sort(al3);

        System.out.println(al1);
        System.out.println(al2);
        System.out.println(al3);

    }


    public static void main(String[] args) {
        init();
        rush();
        display();

//        System.out.println(al);

    }

}
