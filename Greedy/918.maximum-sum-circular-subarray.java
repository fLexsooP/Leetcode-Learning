/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0;
        int curMin = 0;
        int maxTotal = Integer.MIN_VALUE;
        int minTotal = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            curMax += nums[i];
            curMin += nums[i];
            maxTotal = Math.max(curMax, maxTotal);
            minTotal = Math.min(curMin, minTotal);
            curMax = Math.max(curMax, 0);
            curMin = Math.min(curMin, 0);
        }

        return maxTotal > 0 ? Math.max(maxTotal, total - minTotal) : maxTotal;
    }
}
// @lc code=end
