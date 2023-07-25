package com.agan.leetcode.dp;

public class $01_Package {

    public static int packageProblem(int[] weight, int[] value, int bagSize) {
        int goodsSize = weight.length;
        int[][] dp = new int[goodsSize][bagSize + 1];
        //初始化，针对第一个物品，当背包大于物品时，最大价值就是第一个物品的价值
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < goodsSize; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j >= weight[i]) {
                    //能放下物品i，可以选择放还是不放
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                } else {
                    //放不下物品，别选了
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < goodsSize; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[goodsSize-1][bagSize];
    }

    public static void main(String[] args) {
        System.out.println(packageProblem(new int[]{1,3,4}, new int[]{15,20,30}, 4));
    }
}
