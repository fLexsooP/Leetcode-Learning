#
# @lc app=leetcode id=376 lang=python3
#
# [376] Wiggle Subsequence
#

# @lc code=start
class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)
        res = 1
        preDiff = 0
        curDiff = 0
        for i in range(len(nums) - 1):
            curDiff = nums[i + 1] - nums[i]
            if (preDiff <= 0 and curDiff > 0) or (preDiff >= 0 and curDiff < 0):
                res += 1
                preDiff = curDiff
        return res

# @lc code=end
