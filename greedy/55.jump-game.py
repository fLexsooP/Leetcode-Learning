#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxIndex = 0
        i = 0
        if len(nums) <= 1:
            return True
        while i <= maxIndex:
            maxIndex = max(maxIndex, i + nums[i])
            if maxIndex >= len(nums) - 1:
                return True
            i += 1
        return False
# @lc code=end
