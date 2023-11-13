#
# @lc app=leetcode id=337 lang=python3
#
# [337] House Robber III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.mem = dict()

    def rob(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        if root in self.mem:
            return self.mem[root]
        # rob root
        res1 = root.val
        if root.left:
            res1 += self.rob(root.left.left) + self.rob(root.left.right)
        if root.right:
            res1 += self.rob(root.right.left) + self.rob(root.right.right)

        # not rob root
        res2 = self.rob(root.left) + self.rob(root.right)

        self.mem[root] = max(res1, res2)
        return max(res1, res2)
# @lc code=end
