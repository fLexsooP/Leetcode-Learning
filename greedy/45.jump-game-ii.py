#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        cur = 0
        next = 0
        res = 0

        for i in range(len(nums) - 1):
            next = max(next, i + nums[i])
            if i == cur:
                res += 1
                cur = next
        return res
# @lc code=end
