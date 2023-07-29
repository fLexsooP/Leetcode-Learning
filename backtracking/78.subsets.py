#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtracking(startIndex, path):
            if startIndex == len(nums[:]):
                return

            for i in range(startIndex, len(nums)):
                path.append(nums[i])
                res.append(path[:])
                backtracking(i + 1, path)
                path.pop()


        res = [[]]
        backtracking(0, [])
        return res
# @lc code=end
