/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];

        prod[0] = 1;
        prod[1] = nums[0];
        for (int i = 1; i < n; i++) {
            prod[i] = prod[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = n - 2; i > -1; i--) {
            temp = temp * nums[i + 1];
            prod[i] *= temp;
        }

        return prod;
    }
}
// @lc code=end
