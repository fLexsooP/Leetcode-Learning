/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    private int res = 0;
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> diagonalSet = new HashSet<>();
    private Set<Integer> reverseDiagonalSet = new HashSet<>();

    private void backtracking(int row, int n) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || diagonalSet.contains(row - col) || reverseDiagonalSet.contains(row + col)) {
                continue;
            }
            colSet.add(col);
            diagonalSet.add(row - col);
            reverseDiagonalSet.add(row + col);

            backtracking(row + 1, n);

            colSet.remove(col);
            diagonalSet.remove(row - col);
            reverseDiagonalSet.remove(row + col);
        }
    }

    public int totalNQueens(int n) {
        backtracking(0, n);
        return res;
    }
}
// @lc code=end
