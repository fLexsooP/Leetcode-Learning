# Definition for a binary tree node.
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        def traversal(cur):
            if cur is None:
                return
            traversal(cur.left)

            if self.prev is None:
                self.count = 1
            elif self.prev == cur.val:
                self.count += 1
            else:
                self.count = 1
            self.prev = cur.val

            if self.count == self.max_count:
                self.res.append(cur.val)
            elif self.count > self.max_count:
                self.max_count = self.count
                self.res.clear()
                self.res.append(cur.val)

            traversal(cur.right)

        self.prev = None
        self.count = 0
        self.max_count = 0
        self.res = []
        traversal(root)
        return self.res