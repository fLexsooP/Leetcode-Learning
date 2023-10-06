#
# @lc app=leetcode id=2367 lang=python3
#
# [2367] Number of Arithmetic Triplets
#

# @lc code=start
class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        count = 0

        for num in nums:
            if num + diff in nums and num + 2 * diff in nums:
                count += 1
        return count
# @lc code=end
