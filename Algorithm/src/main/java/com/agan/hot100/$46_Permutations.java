package com.agan.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class $46_Permutations {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * <p>
     * <p>
     * 示例 3：
     * <p>
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     * <p>
     * <p>
     * Related Topics 数组 回溯 👍 3312 👎 0
     */


    //leetcode submit region begin(Prohibit modification and deletion)
    List<List<Integer>> result = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        backTracking(nums);
        return result;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            List<Integer> copy = new ArrayList(path);
            result.add(copy);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]==1) {
                continue;
            }
            used[i] = 1;
            path.addLast(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i] = 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        $46_Permutations s = new $46_Permutations();
        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}