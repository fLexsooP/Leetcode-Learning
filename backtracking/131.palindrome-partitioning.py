#
# @lc app=leetcode id=131 lang=python3
#
# [131] Palindrome Partitioning
#

# @lc code=start
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def backtracking(path, startIndex):
            if startIndex == len(s):
                res.append(path[:])
                return

            for i in range(startIndex, len(s)):
                substr = s[startIndex:i + 1]
                if isPalindrome(substr):
                    path.append(substr)
                    backtracking(path, i + 1)
                    path.pop()

        def isPalindrome(str):
            return str == str[::-1]

        res = []
        backtracking([], 0)
        return res

# @lc code=end
