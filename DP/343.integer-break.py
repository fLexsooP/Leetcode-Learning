#
# @lc app=leetcode id=343 lang=python3
#
# [343] Integer Break
#

# @lc code=start
class Solution:
    def integerBreak(self, n: int) -> int:
        if n < 4:
            return n - 1
        dp = [0] * (n + 1)
        dp[2] = 1
        dp[3] = 2

        for i in range(3, n + 1):
            for j in range(1, i // 2 + 1):
                dp[i] = max(dp[i], j * (i - j), j * dp[i - j])

        return dp[n]

# @lc code=end
