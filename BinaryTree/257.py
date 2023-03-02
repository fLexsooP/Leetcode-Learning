# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        path = ''
        res = []
        self.traversal(root, path, res)
        return res
    def traversal(self, cur: Optional[TreeNode], path: str, res: list[str]) -> None:
        path += (str)(cur.val)
        if not cur.left and not cur.right:
            res.append(path)
        if cur.left:
            self.traversal(cur.left, path + '->', res)
        if cur.right:
            self.traversal(cur.right, path + '->', res)