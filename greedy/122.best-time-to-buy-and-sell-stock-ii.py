#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """ greedy
        res = 0
        for i in range(1, len(prices)):
            res += max(prices[i] - prices[i - 1], 0)
        return res
        """

        # dp
        dp = [[0] * 2 for _ in range(len(prices))]
        # hold share
        dp[0][0] = -prices[0]
        # sell share
        dp[0][1] = 0
        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
            dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])
        return dp[len(prices) - 1][1]
# @lc code=end
