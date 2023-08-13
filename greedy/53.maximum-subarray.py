#
# @lc app=leetcode id=53 lang=python3
#
# [53] Maximum Subarray
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = float("-inf")
        sum = 0
        for i in range(len(nums)):
            sum += nums[i]
            res = sum if sum > res else res
            if sum <= 0:
                sum = 0

        return res
# @lc code=end
