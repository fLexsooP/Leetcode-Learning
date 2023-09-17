#
# @lc app=leetcode id=541 lang=python3
#
# [541] Reverse String II
#

# @lc code=start
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res = ""
        index = 0

        while index < len(s):
            res += s[index: index + k][::-1]
            index += k
            res += s[index: index + k]
            index += k

        return res
# @lc code=end
