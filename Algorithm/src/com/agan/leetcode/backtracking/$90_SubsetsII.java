package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class $90_SubsetsII {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //一定要排序。防止[3,1,3,3]
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        result.add(new ArrayList<>(path));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //去重逻辑
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        $90_SubsetsII s = new $90_SubsetsII();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }
}
