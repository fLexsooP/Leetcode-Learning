/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int curSum = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            while (curSum >= target) {
                res = Math.min(res, r - l + 1);
                curSum -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end
