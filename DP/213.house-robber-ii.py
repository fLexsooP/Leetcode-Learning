#
# @lc app=leetcode id=213 lang=python3
#
# [213] House Robber II
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return max(nums)

        # ignore first room
        dp = [0] * n
        dp[1] = nums[1]
        dp[2] = max(nums[1], nums[2])
        for i in range(3, n):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

        res1 = dp[n - 1]

        # ignore last room
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(dp[0], dp[1])
        for i in range(2, n - 1):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])

        res2 = dp[n - 2]

        return max(res1, res2)
# @lc code=end
