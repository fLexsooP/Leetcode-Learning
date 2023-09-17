#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def backtracking(path, used):
            if len(path) == len(nums):
                res.append(path[:])
                return

            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i - 1] and used[i - 1] == 0:
                    continue
                if used[i] == 0:
                    path.append(nums[i])
                    used[i] = 1
                    backtracking(path, used)
                    path.pop()
                    used[i] = 0

        nums.sort()
        initUsed = [0] * len(nums)
        res = []
        backtracking([], initUsed)
        return res
# @lc code=end
