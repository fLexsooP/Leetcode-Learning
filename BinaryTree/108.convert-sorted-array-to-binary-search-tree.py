#
# @lc app=leetcode id=108 lang=python3
#
# [108] Convert Sorted Array to Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def traversal(nums, left, right):
            if left > right:
                return None
            mid = left + (right - left) // 2
            node = TreeNode(nums[mid])
            node.left = traversal(nums, left, mid - 1)
            node.right = traversal(nums, mid + 1, right)
            return node

        left = 0
        right = len(nums) - 1
        return traversal(nums, left, right)

# @lc code=end
