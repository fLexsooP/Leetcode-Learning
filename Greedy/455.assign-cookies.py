#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort(reverse=True)
        s.sort(reverse=True)
        count = 0
        pos = 0

        for i in range(len(g)):
            if pos < len(s) and s[pos] >= g[i]:
                count += 1
                pos += 1
        return count

# @lc code=end
