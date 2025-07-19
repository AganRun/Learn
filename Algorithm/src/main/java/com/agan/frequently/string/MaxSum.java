package com.agan.frequently.string;

/**
 * 最大子序列和
 *
 * 给定一个数列，其中可能有正数也可能有负数，我们的任务是找出其中连续的一个子数列（不允许空序列），使它们的和尽可能大
 */
public class MaxSum {

    public static void main(String[] args) {
        Solution(new Integer[]{0, -1, 2, 3, -100, 6, 2, -1});
    }

    static void Solution(Integer[] array) {
        Integer[] dp = new Integer[array.length];
        Integer result = Integer.MIN_VALUE;
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }

    static void SolutionUltimate(Integer[] array) {
        Integer result = Integer.MIN_VALUE;
        Integer pre = array[0];
        Integer tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = Math.max(pre + array[i], array[i]);
            result = Math.max(result, tmp);
            pre = tmp;
        }
        System.out.println(result);
    }
}
