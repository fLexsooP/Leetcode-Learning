#
# @lc app=leetcode id=738 lang=python3
#
# [738] Monotone Increasing Digits
#

# @lc code=start
class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        strN = str(n)
        listN = list(str(n))
        firstNine = len(listN)
        for i in reversed(range(1, len(listN))):
            if int(listN[i]) < int(listN[i - 1]):
                listN[i] = '9'
                listN[i - 1] = str(int(listN[i - 1]) - 1)
                firstNine = i

        for i in range(firstNine, len(listN)):
            listN[i] = '9'

        return int("".join(listN))

# @lc code=end
