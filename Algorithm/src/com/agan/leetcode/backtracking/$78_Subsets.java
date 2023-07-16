package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class $78_Subsets {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int index) {
        //加入条件。当前元素和，当前元素的向后值都可以加入
        result.add(new ArrayList<>(path));
        //终止条件：就是startIndex已经大于数组的长度了，就终止了，因为没有元素可取了
        if (index >= nums.length) {
            return;
        }
        //横向循环
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);  // 子集收集元素
            backtracking(nums, i+1);  // 注意从i+1开始，元素不重复取
            path.removeLast();   // 回溯
        }
    }

    public static void main(String[] args) {
        $78_Subsets s = new $78_Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
}
