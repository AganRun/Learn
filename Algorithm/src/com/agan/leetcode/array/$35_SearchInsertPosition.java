package com.agan.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $35_SearchInsertPosition {

    /**
     * 二分的基础上，记录最后应该插入在哪里
     * // 分别处理如下四种情况
     * // 目标值在数组所有元素之前  [0, -1]
     * // 目标值等于数组中某一个元素  return middle;
     * // 目标值插入数组中的位置 [left, right]，return  right + 1
     * // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1`
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        $35_SearchInsertPosition searchInsertPosition = new $35_SearchInsertPosition();
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(searchInsertPosition.searchInsert(nums, target));
    }

}
