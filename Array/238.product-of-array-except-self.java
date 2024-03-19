/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        int[] postProduct = new int[n];

        preProduct[0] = 1;
        preProduct[1] = nums[0];
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }

        postProduct[n - 1] = 1;
        postProduct[n - 2] = nums[n - 1];
        for (int i = n - 2; i > -1; i--) {
            postProduct[i] = postProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            preProduct[i] *= postProduct[i];
        }
        return preProduct;

    }
}
// @lc code=end
