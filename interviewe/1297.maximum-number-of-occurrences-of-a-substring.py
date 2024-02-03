#
# @lc app=leetcode id=1297 lang=python3
#
# [1297] Maximum Number of Occurrences of a Substring
#

# @lc code=start
class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        res = {0:0}

        for i in range(len(s) - minSize + 1):
            substr = s[i: i + minSize]
            letters = set(substr)
            if len(letters) <= maxLetters:
                res[substr] = res.get(substr, 0) + 1
        # print(res)
        return max(res.values())
# @lc code=end
