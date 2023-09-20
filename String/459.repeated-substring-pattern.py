#
# @lc app=leetcode id=459 lang=python3
#
# [459] Repeated Substring Pattern
#

# @lc code=start
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        combineS = s[1:] + s[:-1]
        isFindS = combineS.find(s)
        return isFindS != -1
# @lc code=end
