package com.agan.leetcode.list;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class $19_RemoveNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;  //这里很重要，要指向虚节点，不要再new一个了，这样就关联不起来了
        ListNode slow = dummyHead;
        //快指针先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
        //慢指针同步走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        $19_RemoveNodeFromEndList r = new $19_RemoveNodeFromEndList();
        System.out.println(r.removeNthFromEnd(new ListNode(1), 1));;
    }
}
