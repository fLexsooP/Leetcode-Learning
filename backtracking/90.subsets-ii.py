#
# @lc app=leetcode id=90 lang=python3
#
# [90] Subsets II
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def backtracking(path, startIndex):
            if startIndex == len(nums):
                return

            for i in range(startIndex, len(nums)):
                if nums[i] == nums[i - 1] and i > startIndex:
                    continue
                path.append(nums[i])
                res.append(path[:])
                backtracking(path, i + 1)
                path.pop()

        res = [[]]
        nums.sort()
        backtracking([], 0)
        return res
# @lc code=end
