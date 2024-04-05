/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l]);
                l++;
            } else {
                res = Math.max(res, (r - l) * height[r]);
                r--;
            }
        }
        return res;
    }
}
// @lc code=end
