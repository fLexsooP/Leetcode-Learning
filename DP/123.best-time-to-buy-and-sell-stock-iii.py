#
# @lc app=leetcode id=123 lang=python3
#
# [123] Best Time to Buy and Sell Stock III
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 4 for _ in range(n)]

        dp[0][0] = -prices[0]
        dp[0][2] = -prices[0]
        for i in range(1, n):
            # 1st time hold
            dp[i][0] = max(dp[i - 1][0], -prices[i])
            # 1st time not hold
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
            # 2nd time hold
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - prices[i])
            # 2nd time not hold
            dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] + prices[i])

        return dp[n - 1][3]
# @lc code=end
