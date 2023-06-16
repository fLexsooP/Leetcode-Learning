# Definition for a binary tree node.
from typing import Optional
import sys

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.res = float('inf')
        self.prev = None

    def _traversal(self, cur):
        if cur == None:
            return
        left = self._traversal(cur.left)

        if self.prev is not None:
            self.res = min(cur.val - self.prev, self.res)
        self.prev = cur.val

        right = self._traversal(cur.right)

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self._traversal(root)
        return self.res