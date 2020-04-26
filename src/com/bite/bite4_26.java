package com.bite;

/**
 * @Author tjy
 * @Date 2020/4/26 18:53
 */

public class bite4_26 {
    static class Node{
        int val;
        Node next = null;
        Node pre = null;
        Node(int x) {
            this.val = x;
        }
    }

    static class MyLinkedList{
        Node head;
        Node tail;
        int size;
        public MyLinkedList(){
            this.head = null;
            this.tail = null;
            size = 0;
        }

        public void addFirst(int x){
            Node node = new Node(x);
            if (this.head == null){
                this.head = node;
                this.tail = node;
            }else {
                node.next = this.head;
                this.head.pre = node;
                this.head = node;
            }
            size++;
        }

        public void addLast(int x){
            Node node = new Node(x);
            if (this.head == null){
                this.head = node;
                this.tail = node;
            }else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
            size++;
        }

        public void addIndex(int x,int index){
            checkIndex(index);
            if (this.head == null || index == 0){
                addFirst(x);
                return;
            }
            if (index == size-1){
                addLast(x);
                return;
            }
            Node node = new Node(x);
            Node searchIndex = searchIndex(index);
            node.next = searchIndex;
            node.pre = searchIndex.pre;
            searchIndex.pre.next = node;
            searchIndex.pre = node;
            size++;
        }

        private Node searchIndex(int index){

            Node cur = this.head;
            for (int i = 0; i < index; i++){
                cur = cur.next;
            }
            return cur;
        }

        private void checkIndex(int index){
            if (index < 0 || index >= size)
                throw new RuntimeException("角标错误！");
        }

        public void remove(int key){
            if (key == this.head.val){
                this.head = this.head.next;
                this.head.pre.next = null;
                this.head.pre = null;
                size--;
                return;
            }
            if (key == this.tail.val){
                this.tail = this.tail.pre;
                this.tail.next = null;
                size--;
                return;
            }
            Node node = searchKey(key,this.head);
            if (node == null){
                return;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            size--;

        }

        private Node searchKey(int key,Node node){

            Node cur = node;
            while (cur != null){
                if (cur.val == key){
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }

        public void removeallKey(int key){
            Node node = this.head;
           while (node != null){
               if (key == this.head.val){
                   this.head = this.head.next;
                   this.head.pre.next = null;
                   this.head.pre = null;
                   size--;
                   node = this.head;
                   continue;
               }
               if (key == this.tail.val){
                   this.tail = this.tail.pre;
                   this.tail.next = null;
                   size--;
                   continue;
               }
                node = searchKey(key,node);
               if (node == null){
                   break;
               }else{
                   node.pre.next = node.next;
                   node.next.pre = node.pre;
                   size--;
               }

           }
        }

        public boolean contains(int key){
            Node cur = this.head;
            while (cur != null){
                if (cur.val == key){
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

        public void clear(){
            this.head =null;
        }

        public int size(){
            Node cur = this.head;
            int count = 0;
            while (cur != null){
                count++;
                cur = cur.next;
            }
            return count;
        }

        public void display(){
            Node cur = this.head;
            while (cur != null){
                System.out.print(cur.val+"->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(0);
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.removeallKey(3);
//        myLinkedList.addIndex(6,1);
        myLinkedList.display();
        System.out.println(myLinkedList.size);
//        myLinkedList.clear();
//        myLinkedList.display();

    }

}
