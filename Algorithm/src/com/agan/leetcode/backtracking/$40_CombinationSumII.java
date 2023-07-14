package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。 
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class $40_CombinationSumII {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result.stream().distinct().collect(Collectors.toList());
    }

    public void backtracking(int[] nums, int target, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length && target >= sum + nums[i]; i++) {
            //剪枝。上一个相同元素的节点已经使用过了，这里没有必要再重新使用了。所有的可能上一个节点已经实验过了
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, target, nums[i] + sum, i+1);
            path.removeLast();
        }
    }
}
