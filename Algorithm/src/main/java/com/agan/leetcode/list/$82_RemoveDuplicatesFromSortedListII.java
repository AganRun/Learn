package com.agan.leetcode.list;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class $82_RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            //有元素重复
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    //跳过重复的，指向下一个不重复的元素
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        System.out.println(deleteDuplicates(node1));
    }
}
