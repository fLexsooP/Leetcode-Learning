/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] rowMap = new int[9][10];
        int[][] colMap = new int[9][10];
        int[][] blockMap = new int[9][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curNumberRow = Character.getNumericValue(board[i][j]);
                int curNumberCol = Character.getNumericValue(board[j][i]);

                if (curNumberRow != -1) {
                    if (rowMap[i][curNumberRow] == 0) {
                        rowMap[i][curNumberRow]++;
                    } else {
                        return false;
                    }
                }

                if (curNumberCol != -1) {
                    if (colMap[i][curNumberCol] == 0) {
                        colMap[i][curNumberCol]++;
                    } else {
                        return false;
                    }
                }

                if (curNumberRow != -1) {
                    if (blockMap[i / 3 * 3 + j / 3][curNumberRow] == 0) {
                        blockMap[i / 3 * 3 + j / 3][curNumberRow]++;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end
