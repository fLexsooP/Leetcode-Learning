#
# @lc app=leetcode id=701 lang=python3
#
# [701] Insert into a Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:

        def traversal(cur, val):
            if cur is None:
                return root
            if val < cur.val and cur.left:
                return self.insertIntoBST(cur.left, val)
            if val > cur.val and cur.right:
                return self.insertIntoBST(cur.right, val)

            if val < cur.val:
                cur.left = TreeNode(val)
                return
            if val > cur.val:
                cur.right = TreeNode(val)
                return
        if root is None:
            root = TreeNode(val)
        traversal(root, val)
        return root
# @lc code=end
