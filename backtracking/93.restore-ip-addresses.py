#
# @lc app=leetcode id=93 lang=python3
#
# [93] Restore IP Addresses
#

# @lc code=start
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        def backtracking(path, startIndex, numCount):
            if startIndex == len(s) and numCount == 4:
                res.append(path[:-1])
                return

            for i in range(startIndex, len(s)):
                substr = s[startIndex:i + 1]
                if isValid(substr):
                    path += substr
                    path += '.'
                    numCount += 1
                    if numCount > 4:
                        return
                    backtracking(path, i + 1, numCount)
                    path = path[:-1 - len(substr)]
                    numCount -= 1

        def isValid(str):
            if len(str) > 3:
                return False
            if len(str) > 1 and str[0] == '0':
                return False
            return int(str) >= 0 and int(str) <= 255

        res = []
        backtracking("", 0, 0)
        return res
# @lc code=end
