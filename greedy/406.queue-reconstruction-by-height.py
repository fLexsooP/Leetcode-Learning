#
# @lc app=leetcode id=406 lang=python3
#
# [406] Queue Reconstruction by Height
#

# @lc code=start
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        people = sorted(people, reverse=True, key=lambda x: (x[0], -x[1]))
        for person in people:
            res.insert(person[1], person)

        return res
# @lc code=end
