#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#

# @lc code=start
class Solution:
    def __init__(self):
        self.letterMap = [
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        ]

    def letterCombinations(self, digits: str) -> List[str]:
        def backtracking(index, combo):
            if index == len(digits):
                res.append(combo[:])
                return

            digit = int(digits[index])
            letters = self.letterMap[digit]

            # for i in range(len(letters)):
            #     combo += letters[i]
            #     backtracking(index + 1, combo)
            #     combo = combo[:-1]

            for letter in letters:
                combo += letter
                backtracking(index + 1, combo)
                combo = combo[:-1]


        res = []
        if len(digits) == 0:
            return res
        backtracking(0, "")
        return res
# @lc code=end
