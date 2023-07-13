package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class $216_CombinationSumIII {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }

    public void backtracking(int n, int k, int sum, int start) {
        //集合里的个数已经满足,到了就别走了
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //这里的剪枝，自认为是最合理的。前者适用于N很大的适合，后者适用于N很小的适合
        for (int i = start; i <= Math.min(9 - (k - path.size()) + 1, (n - sum)); i++) {
            path.add(i);
            sum += i;
            backtracking(n, k, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        $216_CombinationSumIII c = new $216_CombinationSumIII();
        System.out.println(c.combinationSum3(3,9));
    }
}
