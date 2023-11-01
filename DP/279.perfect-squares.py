#
# @lc app=leetcode id=279 lang=python3
#
# [279] Perfect Squares
#

# @lc code=start
class Solution:
    def numSquares(self, n: int) -> int:
        dp = [float('inf')] * (n + 1)
        dp[0] = 0

        for i in range(1, n + 1):
            for j in range(1, int(n ** 0.5) + 1):
                if i >= j * j:
                    dp[i] = min(dp[i], dp[i - j * j] + 1)

        return dp[n]
# @lc code=end
