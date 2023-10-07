#
# @lc app=leetcode id=343 lang=python3
#
# [343] Integer Break
#

# @lc code=start
class Solution:
    def integerBreak(self, n: int) -> int:
        if n < 4:
            return n - 1

        prod = 1
        while n > 3:
            if n == 4:
                break

            n -= 3
            prod *= 3

        return prod * n
# @lc code=end
