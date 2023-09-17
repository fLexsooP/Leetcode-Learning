from collections import defaultdict
#
# @lc app=leetcode id=332 lang=python3
#
# [332] Reconstruct Itinerary
#

# @lc code=start
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        def dfs(station, targets) :
            while targets[station]:
                nextStation = targets[station].pop()
                dfs(nextStation, targets)
            res.append(station)
        res = []
        targets = defaultdict(list)
        for dept, dest in sorted(tickets, reverse=True):
            targets[dept].append(dest)
        dfs("JFK", targets)
        return res[::-1]
# @lc code=end
