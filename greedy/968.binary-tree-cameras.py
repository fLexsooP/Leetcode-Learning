#
# @lc app=leetcode id=968 lang=python3
#
# [968] Binary Tree Cameras
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self) -> None:
        self.res = 0
    def minCameraCover(self, root: Optional[TreeNode]) -> int:


        # 0: not covered by camera
        # 1: covered by camera
        # 2: is camera
        def traversal(cur):
            if cur is None:
                return 1

            left = traversal(cur.left)
            right = traversal(cur.right)

            if left == 1 and right == 1:
                return 0
            elif left == 0 or right == 0:
                self.res += 1
                return 2
            else:
                return 1

        if traversal(root) == 0:
            self.res += 1
        return self.res
# @lc code=end
