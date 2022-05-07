package com.agan.leetcode.list;

import java.util.LinkedList;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MyLinkedList {

    class ListNode {
        int val;
        MyLinkedList.ListNode prev;
        MyLinkedList.ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, MyLinkedList.ListNode prev, MyLinkedList.ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + (next == null ? "" : "->" + next.toString());
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0, null, null);
        tail = new ListNode(0, null, null);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode dummyNode = head;
        for (int i = 0; i <= index; i++) {
            dummyNode = dummyNode.next;
        }
        return dummyNode.val;
    }

    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val, null, head.next);
        if (head.next != null) {
            head.next.prev = tmp;
        }
        head.next = tmp;
        size++;
        new LinkedList<>();
    }

    public void addAtTail(int val) {
        ListNode tmp = new ListNode(val, tail.next, null);
        if (tail.next != null) {
            tail.next.next = tmp;
        }
        tail.next = tmp;
        size++;
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }

    @Override
    public String toString() {
        return size == 0 ? "[]" : head.next.toString();
    }
}



public class DesignLinkedList$707 {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        System.out.println(list);
        list.addAtTail(3);
        System.out.println(list);
        list.addAtIndex(1,2);
        System.out.println(list);
    }

}
