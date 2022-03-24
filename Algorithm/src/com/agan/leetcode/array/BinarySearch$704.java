package com.agan.leetcode.array;

public class BinarySearch$704 {

    /**
     * https://programmercarl.com/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.html
     * 二分法
     * 使用前提：有序，不重复
     * 关键点：*边界条件*。如果是左闭右闭，则right有意义。应为left<=right,right=mid-1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch$704 bs = new BinarySearch$704();
        System.out.println(bs.search(new int[]{1,0,3,5,9,12}, 13));
    }
}
