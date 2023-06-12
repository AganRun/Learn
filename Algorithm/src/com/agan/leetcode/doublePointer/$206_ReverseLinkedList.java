package com.agan.leetcode.doublePointer;

import com.agan.leetcode.list.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class $206_ReverseLinkedList {

    class Node {
        public int val;

        public Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode t = head;
        ListNode pre = null;
        while (t != null) {
            ListNode n = t.next;
            t.next = pre;
            pre = t;
            t = n;
        }
        return pre;
    }

    public static void main(String[] args) {
        $206_ReverseLinkedList object = new $206_ReverseLinkedList();
//        object.reverseList();
    }
}
