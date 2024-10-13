/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int top = 0;
        int bot = m - 1;
        int row = 0;

        while (top <= bot) {
            int mid = top + ((bot - top) / 2);
            if (target > matrix[mid][0]) {
                top = mid + 1;
            } else if (target < matrix[mid][0]) {
                bot = mid - 1;
            } else {
                return true;
            }
        }
        row = top - 1;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end
