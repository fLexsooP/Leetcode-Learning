#
# @lc app=leetcode id=1481 lang=python3
#
# [1481] Least Number of Unique Integers after K Removals
#

# @lc code=start
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        counter = Counter(arr)
        pq = sorted(counter.items(), key = lambda x: x[1])

        res = len(pq)
        for val, cnt in pq:
            if cnt <= k:
                k -= cnt
                res -= 1
            else:
                return res
        return 0
# @lc code=end
