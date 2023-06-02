package com.agan.leetcode.array;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class $34_Find_first_and_Last_Position_of_Element_in_Sorted_Array {

    /**
     * https://programmercarl.com/0034.%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%92%8C%E6%9C%80%E5%90%8E%E4%B8%80%E4%B8%AA%E4%BD%8D%E7%BD%AE.html#%E6%80%9D%E8%B7%AF
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBorder(nums, target);
        int right = findRightBorder(nums, target);
//        System.out.println(left + "-" + right);
        return new int[]{left, right};
    }

    /**
     * 寻找左边界
     * @param nums
     * @param target
     */
    private int findLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target){  //大于or等于都要继续向左
                right = middle - 1;
            } else {
                //相等的情况，继续向左
                leftBorder = middle;
                right = middle - 1;
            }
        }
        return leftBorder;
    }

    /**
     * 寻找右边界
     * @param nums
     * @param target
     */
    private int findRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target){
                right = middle - 1;
            } else {
                rightBorder = middle;
                left = middle + 1;
            }
        }
        return rightBorder;
    }

    public static void main(String[] args) {
        $34_Find_first_and_Last_Position_of_Element_in_Sorted_Array problem = new $34_Find_first_and_Last_Position_of_Element_in_Sorted_Array();
        problem.searchRange(new int[]{5,6,8,8,8,10}, 5);
    }
}
