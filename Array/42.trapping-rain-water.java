/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int[] minHeight = new int[n];

        int maxL = 0;
        for (int i = 0; i < n; i++) {
            maxLeft[i] = maxL;
            if (height[i] > maxL) {
                maxL = height[i];
            }
        }

        int maxR = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = maxR;
            if (height[i] > maxR) {
                maxR = height[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (maxLeft[i] <= maxRight[i]) {
                minHeight[i] = maxLeft[i];
            } else {
                minHeight[i] = maxRight[i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int diff = minHeight[i] - height[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}
// @lc code=end
