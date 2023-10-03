#
# @lc app=leetcode id=63 lang=python3
#
# [63] Unique Paths II
#

# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][0] = 1

        for i in range(m):
            for j in range(n):
                if i > 0 and obstacleGrid[i - 1][j] != 1:
                    dp[i][j] += dp[i - 1][j]
                if j > 0 and obstacleGrid[i][j - 1] != 1:
                    dp[i][j] += dp[i][j - 1]

        if obstacleGrid[-1][-1] == 1:
            return 0

        return dp[-1][-1]
# @lc code=end
