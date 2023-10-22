class Solution:
    def solve(self)-> int:
        weight = [1, 3, 4]
        value = [15, 20, 30]
        N = 4

        dp = [0] * (N + 1)

        for i in range(len(weight)):
            for j in range(weight[i], N + 1):
                print(dp[j], dp[j - weight[i]] + value[i])
                dp[j] = max(dp[j], dp[j - weight[i]] + value[i])

        print(dp)
        return dp[-1]

s = Solution()
s.solve()