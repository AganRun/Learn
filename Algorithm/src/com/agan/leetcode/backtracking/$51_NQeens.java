package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $51_NQeens {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtracking(n, board, 0);
        return result;
    }

    private void backtracking(int n, String[][] board, int index) {
        if (index == n) {
            List<String> list = array2List(board);
            result.add(list);
            return;
        }
        //这里是遍历列就行。只关注当前行。下一行的数据在递归中向下
        for (int j = 0; j < n; j++) {
            if (valid(board, index, j)) {
                board[index][j] = "Q";
                backtracking(n, board, index + 1);
                board[index][j] = ".";
            }
        }
    }

    public List<String> array2List(String[][] board) {
        int n = board.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean valid(String[][] board, int row, int col) {
        int n = board.length;
        //列是否有重复。结束到row就行，应该下面的还没有填充呢
        for (int i = 0; i < row; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        //-45°斜线是否有重复(斜对角分两种，容易漏掉
        for(int i = row-1, j = col-1 ; i>=0 & j >= 0 ; i--,j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        //45°斜线是否有重复
        for(int i = row-1, j = col+1 ; i>=0 & j < n ; i--,j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        $51_NQeens q = new $51_NQeens();
        System.out.println(q.solveNQueens(5));
    }
}
