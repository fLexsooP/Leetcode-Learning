# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        list = []
        def traversal(root):
            if root == None:
                return
            traversal(root.left)
            list.append(root.val)
            traversal(root.right)
        traversal(root)
        for i in range(1, len(list)):
            if list[i] <= list[i - 1]:
                return False
        return True

    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        left = self.isValidBST(root.left)

        if self.prev != None and self.prev.val >= root.val:
            return False
        self.prev = root

        right = self.isValidBST(root.right)

        return left and right
