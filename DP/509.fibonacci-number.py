#
# @lc app=leetcode id=509 lang=python3
#
# [509] Fibonacci Number
#

# @lc code=start
class Solution:
    def fib(self, n: int) -> int:
        dp = [None] * (n + 1)
        for i in range(n + 1):
            if i == 0:
                dp[0] = 0
            elif i == 1:
                dp[1] = 1
            else:
                dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]

# @lc code=end
