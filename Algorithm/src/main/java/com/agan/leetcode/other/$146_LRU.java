package com.agan.leetcode.other;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 最近最少使用。快手二面、阿里一面有问
 * 需要get set 都是O(1)操作
 */
public class $146_LRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
//        LRUCache cache = new LRUCache(1);
//        cache.put(2,1);
//        System.out.println(cache.get(1));
    }
}

class CNode {

    public Integer key;
    public Integer value;

    public CNode pre;

    public CNode next;

    public CNode (int key, int val) {
        this.key = key;
        this.value = val;
    }
}
class LRUCache {

    Map<Integer, CNode> cache = new HashMap<>();

    int capacity;

    int size;

    CNode dummyHead;
    /**
     * 最不经常使用的元素
     */
    CNode dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        dummyHead = new CNode(-1, -1);
        dummyTail = new CNode(-1, -1);
        dummyTail.pre = dummyHead;
        dummyHead.next = dummyTail;
    }

    public int get(int key) {
        CNode cNode = cache.get(key);
        if (cNode == null) {
            return -1;
        }
        //使用了元素，需要移动到队尾
        removeNode(cNode);
        addToHead(cNode);
        return cNode.value;
    }

    private void addToHead(CNode cNode) {
        cNode.next = dummyHead.next;
        cNode.pre = dummyHead;
        dummyHead.next.pre = cNode;
        dummyHead.next = cNode;
    }

    private void removeNode(CNode cNode) {
        cNode.pre.next = cNode.next;
        cNode.next.pre = cNode.pre;
    }

    public void put(int key, int value) {
        CNode node = cache.get(key);
        if (node == null) {
            CNode newNode = new CNode(key, value);
            //不存在
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                CNode old = dummyTail.pre;
                removeNode(old);
                cache.remove(old.key);
                size--;
            }
        } else {
            //已存在，覆盖
            node.value = value;
            removeNode(node);
            addToHead(node);
        }

    }
}
