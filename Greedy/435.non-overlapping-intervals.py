#
# @lc app=leetcode id=435 lang=python3
#
# [435] Non-overlapping Intervals
#

# @lc code=start
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        res = 0
        intervals = sorted(intervals)
        prev_end = intervals[0][1]

        for start, end in intervals[1:]:
            if start < prev_end:
                res += 1
                prev_end = min(prev_end, end)
            else:
                prev_end = end

        return res
# @lc code=end
