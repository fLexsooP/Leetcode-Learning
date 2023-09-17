#
# @lc app=leetcode id=216 lang=python3
#
# [216] Combination Sum III
#

# @lc code=start
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def backtracking(path, sum, start):
            if sum > n:
                return

            if len(path) == k and sum == n :
                res.append(path[:])
                return

            for i in range(start, 10 - (k - len(path)) + 1):
                sum += i
                path.append(i)

                backtracking(path, sum, i + 1)
                sum -= i
                path.pop()


        res = []
        backtracking([], 0, 1)
        return res
# @lc code=end
