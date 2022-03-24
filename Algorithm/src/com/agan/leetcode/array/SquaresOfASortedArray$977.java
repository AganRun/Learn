package com.agan.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SquaresOfASortedArray$977 {

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] arr = new int[n];
        while (j >= i) {
            if ((nums[i] * nums[i]) >= (nums[j] * nums[j])) {
                arr[--n] = nums[i] * nums[i];
                i++;
            } else {
                arr[--n] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray$977 s = new SquaresOfASortedArray$977();
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
