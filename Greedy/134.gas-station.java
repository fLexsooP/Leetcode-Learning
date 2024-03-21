/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalDiff = 0;
        int curSum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int remainGas = gas[i] - cost[i];
            totalDiff += remainGas;
            curSum += remainGas;
            if (curSum < 0) {
                res = i + 1;
                curSum = 0;
            }
        }

        if (totalDiff < 0) {
            return -1;
        }
        return res;
    }
}
// @lc code=end
