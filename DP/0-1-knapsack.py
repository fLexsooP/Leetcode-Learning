class Solution:
    def solve(self)-> int:
        weight = [1, 3, 4]
        value = [15, 20, 30]
        N = 4

        dp = [[0] * (N + 1) for _ in range(len(weight))]
        for i in range(weight[0], N + 1):
            dp[0][i] = value[0]

        for i in range(1, len(weight)):
            for j in range(1, N + 1):
                if j < weight[i]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]])

        print(dp)
        return dp[-1][-1]

s = Solution()
s.solve()