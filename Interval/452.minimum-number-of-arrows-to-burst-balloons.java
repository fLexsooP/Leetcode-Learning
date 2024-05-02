
/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1;
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                right = Math.min(points[i][1], right);
            } else {
                res += 1;
                right = points[i][1];
            }
        }
        return res;
    }
}
// @lc code=end
