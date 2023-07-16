package com.agan.leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-decreasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $491_NondecreasingSubsequences {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int index) {
        //加入条件。由于是序列，元素长度需要大于1
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        //终止条件
        if (index >= nums.length) {
            return;
        }
        //需要去重。同一个父节点下，使用过的就不要用了。放在for之前，以为层序之前，层序里里的都是兄弟节点
        Set<Integer> used = new HashSet<>();
        //横向循环
        for (int i = index; i < nums.length; i++) {
            //需要递增的才能向下 且去重
            if ((path.size() > 0 && nums[i] < path.getLast()) || used.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            used.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        $491_NondecreasingSubsequences s = new $491_NondecreasingSubsequences();
        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
