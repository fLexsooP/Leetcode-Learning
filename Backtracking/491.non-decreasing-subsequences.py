#
# @lc app=leetcode id=491 lang=python3
#
# [491] Non-decreasing Subsequences
#

# @lc code=start
class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        def backtracking(path, startIndex):
            if len(path) > 1:
                res.append(path[:])

            used = set()
            for i in range(startIndex, len(nums)):
                if nums[i] in used:
                    continue
                if not path or nums[i] >= path[-1]:
                    used.add(nums[i])
                    path.append(nums[i])
                    backtracking(path, i + 1)
                    path.pop()


        res = []
        backtracking([], 0)
        return res
# @lc code=end
