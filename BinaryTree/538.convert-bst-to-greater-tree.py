#
# @lc app=leetcode id=538 lang=python3
#
# [538] Convert BST to Greater Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def traversal(self, cur):
        if cur is None:
            return
        self.traversal(cur.right)
        cur.val += self.sum
        self.sum = cur.val
        self.traversal(cur.left)

    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.sum = 0
        self.traversal(root)
        return root
# @lc code=end
