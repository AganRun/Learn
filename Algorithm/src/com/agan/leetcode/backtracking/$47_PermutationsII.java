package com.agan.leetcode.backtracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $47_PermutationsII {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;  //记录每次层级加1的节点选取记录
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> currentUsed = new HashSet<>();  //记录当前同一层级的选取记录
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || currentUsed.contains(nums[i])) {
                continue;
            }
            currentUsed.add(nums[i]);
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        $47_PermutationsII p = new $47_PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
    }

}
