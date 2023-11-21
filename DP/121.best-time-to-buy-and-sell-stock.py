#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        dp = [[0] * 2 for _ in range(len(prices))]
        # hold
        dp[0][0] = -prices[0]
        # sell
        dp[0][1] = 0

        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i - 1][0], -prices[i])
            dp[i][1] = max(prices[i] + dp[i - 1][0], dp[i - 1][1])

        return dp[len(prices) - 1][1]
        '''

        '''
        res = 0
        low = float("inf")
        for i in range(len(prices)):
            low = min(prices[i], low)
            res = max(res, prices[i] - low)
            print(low, res)

        return res
        '''

        left = 0 #Buy
        right = 1 #Sell
        max_profit = 0
        while right < len(prices):
            currentProfit = prices[right] - prices[left] #our current Profit
            if prices[left] < prices[right]:
                max_profit =max(currentProfit,max_profit)
            else:
                left = right
            right += 1
        return max_profit
# @lc code=end
