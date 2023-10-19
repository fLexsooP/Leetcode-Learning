#
# @lc app=leetcode id=494 lang=python3
#
# [494] Target Sum
#

# @lc code=start
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)

        if total < abs(target):
            return 0

        if (total + target) % 2 == 1:
            return 0
        # left - right = target, right = total - left
        # left - (total - left) = target
        # 2 left = target + total
        left = (total + target) // 2
        dp = [0] * (left + 1)
        dp[0] = 1

        for i in range(len(nums)):
            for j in range(left, nums[i] - 1, -1):
                dp[j] += dp[j - nums[i]]

        return dp[left]
# @lc code=end
