#
# @lc app=leetcode id=474 lang=python3
#
# [474] Ones and Zeroes
#

# @lc code=start
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for string in strs:
            count_0 = string.count("0")
            count_1 = string.count("1")

            # dp[i][j]: i=number of 0, j=number of 1
            for i in range(m, count_0 - 1, -1):
                for j in range(n, count_1 - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - count_0][j - count_1] + 1)

        return dp[m][n]
# @lc code=end
