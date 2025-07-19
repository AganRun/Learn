package com.agan.leetcode.backtracking;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $37_SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    /**
     * 因为存在一个解法，就可以返回，所以需要有返回值
     * @param board
     * @param row
     * @return
     */
    private boolean backtracking(char[][] board) {
        //不需要终止条件，棋盘满了自然停止
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != '.') {  //棋盘上已经有值了，跳过
                    continue;
                }
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                //9个数组试完了，还不行，没有找到解法
                return false;
            }
        }
        //遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int n = board.length;
        //行和列是否有目标数组
        for (int i = 0; i < n; i++) {
            if (board[i][col] == num || board[row][i] == num) {
                return false;
            }
        }
        //3*3的单元格，是否有目标数组   i和j的起止，围成了3*3的棋盘
        for (int i = row/3*3; i < row/3*3 + 3; i++) {
            for (int j = col/3*3; j < col/3*3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
