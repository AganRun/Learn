package com.agan.hot100;

public class $79_WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, used))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] used) {
        if (idx == word.length()) return true;                 // 全部匹配成功
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (used[i][j] || board[i][j] != word.charAt(idx)) return false;

        used[i][j] = true;
        // 四个方向尝试
        boolean found = dfs(board, i + 1, j, word, idx + 1, used)
                || dfs(board, i - 1, j, word, idx + 1, used)
                || dfs(board, i, j + 1, word, idx + 1, used)
                || dfs(board, i, j - 1, word, idx + 1, used);
        used[i][j] = false;   // 回溯
        return found;
    }

    public static void main(String[] args) {
        //输入：[["a","b"]], word = ""ba""
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        $79_WordSearch s = new $79_WordSearch();
        System.out.println(s.exist(board, word));
    }
}
