#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1

        # m: player can climb 1 to m step at a time
        m = 2

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if i >= j:
                    dp[i] += dp[i - j]

            print(dp)
        return dp[n]
# @lc code=end
