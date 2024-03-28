/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];

        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                res += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }
        }
        return res;
    }
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int[] maxLeft = new int[n];
    //     int[] maxRight = new int[n];
    //     int[] minHeight = new int[n];

    //     int maxL = 0;
    //     for (int i = 0; i < n; i++) {
    //         maxLeft[i] = maxL;
    //         if (height[i] > maxL) {
    //             maxL = height[i];
    //         }
    //     }

    //     int maxR = 0;
    //     for (int i = n - 1; i >= 0; i--) {
    //         maxRight[i] = maxR;
    //         if (height[i] > maxR) {
    //             maxR = height[i];
    //         }
    //     }

    //     for (int i = 0; i < n; i++) {
    //         if (maxLeft[i] <= maxRight[i]) {
    //             minHeight[i] = maxLeft[i];
    //         } else {
    //             minHeight[i] = maxRight[i];
    //         }
    //     }

    //     int res = 0;
    //     for (int i = 0; i < n; i++) {
    //         int diff = minHeight[i] - height[i];
    //         if (diff > 0) {
    //             res += diff;
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
