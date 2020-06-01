package com.bite.ds;

/**
 * @Author tjy
 * @Date 2020/6/1 14:58
 */

public class MyHashMap<K,V> {

    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;
        public Node(K key,V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array = (Node<K,V>[])new Node[10];
    public int usedSize;

    public void put(K key,V val) {

        int index = key.hashCode() % array.length;
        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key) ) {
                //key相同 更新val值
                cur.val = val;
                return;
            }
        }
        Node<K,V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if (loadFactor() > 0.75) {
            resize();
        }
    }

    public V get(K key){
        int index = key.hashCode() % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }

        return null;

    }

    private void resize() {
        Node<K,V>[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = this.array[i];
            while (cur != null){
                int index = cur.key.hashCode() % newArray.length;
                Node<K,V> node = cur;
                node.next = newArray[index];
                newArray[index] = node;
                cur = cur.next;
            }
        }
        this.array = newArray;
    }

    private double loadFactor() {
        return this.usedSize *1.0 / array.length;
    }

}
