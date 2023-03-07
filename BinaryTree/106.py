# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def traversal(inorder, inorder_begin, inorder_end, postorder, postorder_begin, postorder_end) -> Optional[TreeNode]:
            if postorder_begin == postorder_end:
                return None
            root_value = postorder[postorder_end - 1]
            root = TreeNode(root_value)
            if postorder_end - postorder_begin == 1:
                return root
            
            # delimiter = 0
            # for value in inorder:
            #     if value == root_value:
            #         break
            #     delimiter += 1
            delimiter = inorder.index(root_value)
            
            # left_inorder = [i for i in inorder[:delimiter]]
            # right_inorder = [i for i in inorder[delimiter + 1:]]
            left_inorder_begin = inorder_begin
            left_inorder_end = delimiter
            right_inorder_begin = delimiter + 1
            right_inorder_end = inorder_end
            
            # left_postorder = [i for i in postorder[:len(left_inorder)]]
            # right_postorder = [i for i in postorder[len(left_inorder):-1]]
            left_postorder_begin = postorder_begin
            left_postorder_end = postorder_begin + (delimiter - inorder_begin)
            right_postorder_begin = postorder_begin + (delimiter - inorder_begin)
            right_postorder_end = postorder_end - 1
            
            
            root.left = traversal(inorder, left_inorder_begin, left_inorder_end, postorder, left_postorder_begin, left_postorder_end)
            root.right = traversal(inorder, right_inorder_begin, right_inorder_end, postorder, right_postorder_begin, right_postorder_end)

            return root
        
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        return traversal(inorder, 0, len(inorder), postorder, 0, len(postorder))