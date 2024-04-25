/*
 * @lc app=leetcode id=1886 lang=java
 *
 * [1886] Determine Whether Matrix Can Be Obtained By Rotation
 */

// @lc code=start
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean[] rotate = new boolean[4];
        for (int i = 0; i < rotate.length; i++) {
            rotate[i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // same
                if (mat[i][j] != target[i][j]) {
                    rotate[0] = false;
                }

                // clockwise 90˚
                if (mat[i][j] != target[j][n - 1 - i]) {
                    rotate[1] = false;
                }

                // counter clockwise 90˚
                if (mat[i][j] != target[n - 1 - j][i]) {
                    rotate[2] = false;
                }

                // 180˚
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    rotate[3] = false;
                }
            }
        }
        return rotate[0] || rotate[1] || rotate[2] || rotate[3];
    }
}
// @lc code=end
