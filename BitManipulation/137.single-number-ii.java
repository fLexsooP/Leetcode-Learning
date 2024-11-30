/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;

            for (int num : nums) {
                int bit = (num >> i) & 1;
                bitSum += bit;
            }

            int resBit = bitSum % 3;
            res = res | (resBit << i);
        }
        return res;
    }
}
// @lc code=end
