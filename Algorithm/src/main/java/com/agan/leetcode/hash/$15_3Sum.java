package com.agan.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $15_3Sum {

    /**
     * 三数之和，双指针法。
     * 先遍历一层，就变成了两数之和，然后利用排序+双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            //剪枝，当前值大于0，目标和一定大于0，直接下一步
            if (nums[i] > 0) {
                return result;
            }
            //如果元素与之前重合，就不要再判断了
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    result.add(Stream.of(nums[i], nums[l], nums[r]).collect(Collectors.toList()));
                    //此处一定要去重，不能简单的移动双指针，不然-2,0,0,2,2的样例会输出一样的结果
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        $15_3Sum sum = new $15_3Sum();
        System.out.println(sum.threeSum(new int[]{-2,0,0,2,2}));
    }
}
