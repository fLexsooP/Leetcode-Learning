#
# @lc app=leetcode id=56 lang=python3
#
# [56] Merge Intervals
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals)
        res = []
        prev_start = intervals[0][0]
        prev_end = intervals[0][1]

        for start, end in intervals[1:]:
            if start <= prev_end:
                prev_end = max(prev_end, end)
            else:
                res.append([prev_start, prev_end])
                prev_start = start
                prev_end = end

        res.append([prev_start, prev_end])
        return res


# @lc code=end
