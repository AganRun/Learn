package com.agan.leetcode.list;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 */
public class $02_07_IntersectionOfTwoLinkedListsLCCI {

    /**
     * 先计算长度，
     * 如果能相交，后面的长度是一直的，
     * 移动到和短列表相同长度的位置，然后同时向后开始比较
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode dummyNodeA = new ListNode();
        dummyNodeA.next = headA;
        while (dummyNodeA.next != null) {
            lengthA ++;
            dummyNodeA = dummyNodeA.next;
        }
        ListNode dummyNodeB = new ListNode();
        dummyNodeB.next = headB;
        while (dummyNodeB.next != null) {
            lengthB ++;
            dummyNodeB = dummyNodeB.next;
        }

        dummyNodeA = headA;
        dummyNodeB = headB;
        if (lengthA > lengthB) {
            int gap = lengthA - lengthB;
            while (gap-- > 0) {
                dummyNodeA = dummyNodeA.next;
            }
        } else {
            int gap = lengthB - lengthA;
            while (gap-- > 0) {
                dummyNodeB = dummyNodeB.next;
            }
        }
        while (dummyNodeB != null && dummyNodeA != null) {
            if (dummyNodeA == dummyNodeB) {
                return dummyNodeB;
            }
            dummyNodeA = dummyNodeA.next;
            dummyNodeB = dummyNodeB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
