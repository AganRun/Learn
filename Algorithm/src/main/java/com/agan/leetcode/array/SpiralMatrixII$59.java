package com.agan.leetcode.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * [1,2,3]
 * [8,9,4]
 * [7,6,5]
 */
public class SpiralMatrixII$59 {

    /**
     * K神的解法
     * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n-1, t = 0, b = n-1;
        int[][] mat = new int[n][n];
        int tar = n*n;
        int cur = 1;
        while(cur <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = cur++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                mat[i][r] = cur++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                mat[b][i] = cur++;
            }
            b--;
            for (int i = b; i>= t; i--) {
                mat[i][l] = cur++;
            }
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        SpiralMatrixII$59 s = new SpiralMatrixII$59();
        System.out.println(s.generateMatrix(3));
    }
}
