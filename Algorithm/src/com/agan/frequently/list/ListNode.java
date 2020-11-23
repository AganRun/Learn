package com.agan.frequently.list;

/**
 * 链表的节点
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    @Override
    public String toString() {
        return val + ((next != null) ? (", " + next) : "");
    }
}
