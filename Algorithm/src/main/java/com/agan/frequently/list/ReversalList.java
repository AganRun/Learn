package com.agan.frequently.list;

/**
 * @author wangzhuo
 *
 * 剑指 offer:输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReversalList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        list.next = node2;
        node2.next = node3;
        System.out.println(list);
        list = solution(list);
        System.out.println(list);
    }

    /**
     * before: 1->2->3
     * after： 3->2->1
     *
     * head
     * 1---->2---->3
     *     next
     * pre
     * @param head
     */
    static ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
