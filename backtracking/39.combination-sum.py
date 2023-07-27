#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtracking(startIndex, path, sum):
            if sum > target:
                return

            if sum == target:
                res.append(path[:])
                return

            for i in range(startIndex, len(candidates)):
                sum += candidates[i]
                if sum > target:
                    break
                path.append(candidates[i])
                backtracking(i, path, sum)
                sum -= path[-1]
                path.pop()

        candidates.sort()
        res = []
        backtracking(0, [], 0)
        return res
# @lc code=end
