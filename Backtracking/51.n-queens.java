/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private List<List<String>> res = new ArrayList<>();

    private boolean isValid(int row, int col, char[][] board, int n) {
        int i = 0;
        int j = 0;
        for (; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void backtracking(int row, int n, char[][] board) {
        if (row == n) {

            res.add(toBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board, n)) {
                board[row][col] = 'Q';
                backtracking(row + 1, n, board);
                board[row][col] = '.';
            }
        }
    }

    private List<String> toBoard(char[][] board) {
        List<String> newBoard = new ArrayList<>();
        for (char[] row: board) newBoard.add(new String(row));
        return newBoard;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(0, n, board);
        return res;

    }
}
// @lc code=end
