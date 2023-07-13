package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class $77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> item = new LinkedList<>();

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param start 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    public void backtracking(int n, int k, int start) {
        //终止条件
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }
//        for (int i = start; i <= n; i++) {
        //优化，剪枝
        for (int i = start; i <= (n - (k - item.size()) + 1); i++) {
            item.add(i);
            backtracking(n, k, i+1);
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        $77_Combinations c = new $77_Combinations();
        System.out.println(c.combine(4,2));
    }

}
