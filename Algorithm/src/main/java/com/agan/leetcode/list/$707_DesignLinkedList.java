package com.agan.leetcode.list;


/**
 * 实现 MyLinkedList 类：
 *
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $707_DesignLinkedList {
    MyLinkedList m = new MyLinkedList();

    class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        public ListNode(){
            this.val = -1;
        }
        public ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "->" + next;
            }
            return String.valueOf(val);
        }
    }

    class MyLinkedList {

        int size = 0;
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            }
            ListNode find = new ListNode();
            find = head;
            while (index-- >= 0) {
                find = find.next;
            }
            return find.val;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head.next;
            newHead.pre = head;
            head.next.pre = newHead;
            head.next = newHead;
            size++;
        }

        public void addAtTail(int val) {
            ListNode newTail = new ListNode(val);
            newTail.next = tail;
            newTail.pre = tail.pre;
            tail.pre.next = newTail;
            tail.pre = newTail;
            size++;
        }

        public void addAtIndex(int index, int val) {
             if (index > size || index < 0) {
                 return;
             }
             ListNode pre = head;
             while (index-- > 0) {
                pre = pre.next;
             }
             ListNode node = new ListNode(val);
             node.next = pre.next;
             node.pre = pre;
             if (pre.next != null) {
                 pre.next.pre = node;
             }
             pre.next = node;
             size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) return;
            ListNode pre = head;
            while (index-- > 0) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            pre.next.pre = pre;
            size--;
        }

        public void main(String[] args) {
            MyLinkedList m = new MyLinkedList();
            m.addAtHead(2);
            m.addAtHead(1);
        }

    }

    public static void main(String[] args) {
        $707_DesignLinkedList d = new $707_DesignLinkedList();
        d.m.addAtHead(4);
        System.out.println(d.m.get(1));
        d.m.addAtHead(1);
        d.m.addAtHead(5);
        d.m.deleteAtIndex(3);
        d.m.addAtHead(7);
        System.out.println(d.m.get(3));
        System.out.println(d.m.get(3));
        System.out.println(d.m.get(3));
        d.m.addAtHead(1);
        System.out.println(d.m.get(4));
    }


}
