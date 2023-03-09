# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        
        def traversal(nums: List[int], begin: int, end: int) -> Optional[TreeNode]:
            if begin >= end:
                return None

            max_index = begin
            for index in range(begin, end):
                if nums[index] > nums[max_index]:
                    max_index = index
            root = TreeNode(nums[max_index])
            
            root.left = traversal(nums, begin, max_index)
            root.right = traversal(nums, max_index + 1, end)
            return root
        
        return traversal(nums, 0, len(nums))