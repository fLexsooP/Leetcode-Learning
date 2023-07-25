#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#

# @lc code=start
class Solution:
    def backtracking(self, n, k, start):
        if len(self.path) == k:
            self.res.append(self.path[:])
            return

        for i in range(start, n + 1):
            self.path.append(i)
            self.backtracking(n, k, i + 1)
            self.path.pop()

    def combine(self, n: int, k: int) -> List[List[int]]:
        self.path = []
        self.res = []
        self.backtracking(n, k, 1)
        return self.res

# @lc code=end
