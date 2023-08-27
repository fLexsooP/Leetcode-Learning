#
# @lc app=leetcode id=134 lang=python3
#
# [134] Gas Station
#

# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start = 0
        totalSum = 0
        curSum = 0

        for i in range(len(gas)):
            rest = gas[i] - cost[i]
            totalSum += rest
            curSum += rest
            if curSum < 0:
                start = i + 1
                curSum = 0

        if totalSum < 0:
            return -1
        return start
# @lc code=end
