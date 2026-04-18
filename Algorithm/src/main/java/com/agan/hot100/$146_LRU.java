package com.agan.hot100;

import java.util.HashMap;
import java.util.Map;

/** LeetCode 146：双向链表 + HashMap；提交时可将 {@link LRUCache} 单独拷成 public 类。 */
public class $146_LRU {

    static class LRUCache {

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node() {}

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final Map<Integer, Node> map;
        private final int capacity;
        private final Node head;
        private final Node tail;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Node removed = removeTail();
                map.remove(removed.key);
                size--;
            }
        }

        private void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private Node removeTail() {
            Node last = tail.prev;
            removeNode(last);
            return last;
        }
    }

    // 与 LeetCode 官方示例一致
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        check("get(1)", 1, lRUCache.get(1));
        lRUCache.put(3, 3);
        check("get(2)", -1, lRUCache.get(2));
        lRUCache.put(4, 4);
        check("get(1)", -1, lRUCache.get(1));
        check("get(3)", 3, lRUCache.get(3));
        check("get(4)", 4, lRUCache.get(4));
        System.out.println("LeetCode 官方样例全部通过。");
    }

    private static void check(String name, int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(name + ": 期望 " + expected + "，实际 " + actual);
        }
        System.out.println(name + " => " + actual + " (ok)");
    }
}
