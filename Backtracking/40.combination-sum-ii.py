#
# @lc app=leetcode id=40 lang=python3
#
# [40] Combination Sum II
#

# @lc code=start
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtracking(path, startIndex, sum):
            if sum == target:
                res.append(path[:])

            for i in range(startIndex, len(candidates)):
                if candidates[i] == candidates[i - 1] and i > startIndex:
                    continue

                sum += candidates[i]
                if sum > target:
                    return
                path.append(candidates[i])
                backtracking(path, i + 1, sum)
                sum -= path[-1]
                path.pop()

        candidates.sort()
        res = []
        backtracking([], 0, 0)
        return res
# @lc code=end
