package com.agan.leetcode.list;

import java.lang.management.LockInfo;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class $24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead  = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next!= null) {
            ListNode f1 = cur.next;
            ListNode f2 = cur.next.next;
            cur.next = f2;
            f1.next = f2.next;
            f2.next = f1;
            cur = f1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        $24_SwapNodesInPairs s = new $24_SwapNodesInPairs();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(s.swapPairs(l1));
    }

}
