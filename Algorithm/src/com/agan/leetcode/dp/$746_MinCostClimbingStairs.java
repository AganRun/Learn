package com.agan.leetcode.dp;

import java.util.Arrays;

public class $746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;//可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        $746_MinCostClimbingStairs c = new $746_MinCostClimbingStairs();
        System.out.println(c.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
