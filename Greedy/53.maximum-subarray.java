/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxTotal = Integer.MIN_VALUE;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
            maxTotal = Math.max(maxTotal, total);
            total = Math.max(total, 0);
        }

        return maxTotal;
    }
}
// @lc code=end
