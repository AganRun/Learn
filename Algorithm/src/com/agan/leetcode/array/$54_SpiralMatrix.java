package com.agan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class $54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int button = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > button) {
                break;
            }
            for (int i = top; i <= button; i++) {
                res.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[button][i]);
            }
            if (top > --button) {
                break;
            }
            for (int i = button; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(arr));
    }
}
