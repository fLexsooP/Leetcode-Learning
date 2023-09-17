#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtracking(path, used):
            if len(path) == len(nums):
                res.append(path[:])
                return

            for i in range(len(nums)):
                if used[i] == 0:
                    used[i] = 1
                    path.append(nums[i])
                    backtracking(path, used)
                    used[i] = 0
                    path.pop()

        initUsed = [0] * len(nums)
        res = []
        backtracking([], initUsed)
        return res
# @lc code=end
