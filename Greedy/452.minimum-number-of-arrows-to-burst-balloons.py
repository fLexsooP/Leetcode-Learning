#
# @lc app=leetcode id=452 lang=python3
#
# [452] Minimum Number of Arrows to Burst Balloons
#

# @lc code=start
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        res = 1
        points = sorted(points)
        print(points)
        prev_end = points[0][1]

        for start, end in points[1:]:
            if start > prev_end:
                res += 1
                prev_end = end
            else:
                prev_end = min(prev_end, end)

        return res
# @lc code=end
