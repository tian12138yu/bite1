package com.bite;

/**
 * @Author tjy
 * @Date 2020/4/20 19:26
 */



public class bite4_20 {
    static class Node{
        int val;
        Node next = null;
        Node(int x){
            this.val=x;
        }
    }

    static class MyLinkedList{

        private Node head;
        private int size;


        public MyLinkedList(){
            head = null;
            size = 0;
        }

        public MyLinkedList(int x){
            Node node = new Node(x);
            head = node;
            size = 1;
        }

        public void addFirst(int x){
            Node node = new Node(x);
            if (size == 0){
                this.head = node;
                size = 1;
                return;
            }

            node.next = this.head;
            this.head = node;
            size++;

        }

        public void addLast(int x){
            if (size == 0){
                this.head = new Node(x);
                size = 1;
                return;
            }

            Node cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(x);
            size++;
        }

        public void addIndex(int x,int index){

            if (index == 0){
                addFirst(x);
                return;
            }
            if (index == size){
                addLast(x);
                return;
            }
            Node node = new Node(x);

            Node cur =searchIndex(index);
            node.next = cur.next;
            cur.next = node;

        }

        private Node searchIndex(int index){
            if (index < 0|| index > size)throw new RuntimeException("角标错误！");
            Node cur = head;
            for (int i = 0; i < index-1; i++){
                cur = cur.next;
            }
            return cur;
        }

        public boolean constains(int x){
            Node cur = this.head;
            while(cur != null){
                if (cur.val == x)return true;
                cur = cur.next;
            }
            return false;
        }

        public int size(){
            return size;
//            Node cur = this.head;
//            int count = 0;
//            while(cur != null){
//                cur = cur.next;
//                count++;
//            }
//            return count;
        }

        public void display(){
            Node cur = this.head;
            while (cur != null){
                System.out.print(cur.val + "->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int x = 0; x < 10; x++ ){
            myLinkedList.addFirst(x);
        }
        for (int x = 0; x < 10; x++ ){
            myLinkedList.addLast(x);
        }
        myLinkedList.display();
        System.out.println(myLinkedList.size);
    }

}
