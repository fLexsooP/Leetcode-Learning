/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public int getNeighbors(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int neighbors = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                if (board[x][y] == 1 || board[x][y] == 3) {
                    neighbors++;
                }
            }
        }
        neighbors -= board[i][j];
        return neighbors;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = getNeighbors(board, i, j);

                // 3 means current gen is 1 and next gen will be 1
                if (board[i][j] == 1 && neighbors >= 2 && neighbors <= 3) {
                    board[i][j] = 3;
                }

                // 2 means current gen is 0 but next gen will be 1
                if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end
