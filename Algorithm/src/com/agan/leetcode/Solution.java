package com.agan.leetcode;


import java.util.Arrays;

public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return true;
    }

    public int[] sortedSquares(int[] nums) {
        int newTail = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        int[] targetArr = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                targetArr[newTail--] = nums[right] * nums[right];
                right--;
            } else {
                targetArr[newTail--] = nums[left] * nums[left];
                left++;
            }
        }
        return targetArr;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            if (sum < target) {
                right++;
            } else if (sum == target) {
                min = Math.min(min, right - left + 1);
                sum += nums[right];
                right++;
            } else {
                while (sum > target && left < nums.length) {
                    sum -= nums[left];
                    left++;
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return 0;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode index = pre;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return index.next;
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.backspaceCompare("abc#c", "#"));
//        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, 0, 3})));
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
