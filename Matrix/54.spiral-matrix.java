/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        int bot = matrix.length - 1;
        int right = matrix[0].length - 1;
        int n = (bot + 1) * (right + 1);
        int[] res = new int[n];
        int i = 0;
        int cur;
        while (i < n) {
            cur = left;
            while (cur <= right && i < n) {
                res[i++] = matrix[top][cur++];
            }
            top++;

            cur = top;
            while (cur <= bot && i < n) {
                res[i++] = matrix[cur++][right];
            }
            right--;

            cur = right;
            while (cur >= left && i < n) {
                res[i++] = matrix[bot][cur--];
            }
            bot--;

            cur = bot;
            while (cur >= top && i < n) {
                res[i++] = matrix[cur--][left];
            }
            left++;
        }
        return Arrays.stream(res).boxed().toList();
    }
}
// @lc code=end
