/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    boolean isExist = false;

    void helper(char[][] board, boolean[][] passed, String word, int x, int y, int currIndex) {
        if (currIndex == word.length()) {
            isExist = true;
            return;
        }

        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || passed[x][y]) {
            return;
        }

        char currChar = word.charAt(currIndex);
        if (currChar == board[x][y]) {
            passed[x][y] = true;
            helper(board, passed, word, x - 1, y, currIndex + 1);
            helper(board, passed, word, x + 1, y, currIndex + 1);
            helper(board, passed, word, x, y - 1, currIndex + 1);
            helper(board, passed, word, x, y + 1, currIndex + 1);
            passed[x][y] = false;
        }
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] passed = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    helper(board, passed, word, i, j, 0);
                }
            }
        }
        return isExist;
    }
}
// @lc code=end
