# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        left_length = 0
        right_length = 0
        left = root.left
        right = root.right
        while left:
            left = left.left
            left_length += 1
        while right:
            right = right.right
            right_length += 1
        if left_length == right_length:
            return 2 ** (left_length + 1) - 1
        return self.countNodes(root.left) + self.countNodes(root.right) + 1
