#
# @lc app=leetcode id=763 lang=python3
#
# [763] Partition Labels
#

# @lc code=start
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastPosition = {k: 0 for k in range(26)}
        for i in range(len(s)):
            lastPosition[ord(s[i]) - ord('a')] = i

        res = []
        l, r = 0, 0
        for i in range(len(s)):
            r = max(r, lastPosition[ord(s[i]) - ord('a')])
            if i == r:
                res.append(r - l + 1)
                l = i + 1
        return res

# @lc code=end
