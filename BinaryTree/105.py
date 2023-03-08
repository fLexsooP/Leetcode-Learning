# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def traversal(preorder, preorder_begin, preorder_end, inorder, inorder_begin, inorder_end) -> Optional[TreeNode]:
            if preorder_begin == preorder_end:
                return None
            root_value = preorder[preorder_begin]
            root = TreeNode(root_value)
            if preorder_end - preorder_begin == 1:
                return root
            
            delimiter = inorder.index(root_value)
            
            left_inorder_begin = inorder_begin
            left_inorder_end = delimiter
            
            right_inorder_begin = delimiter + 1
            right_inorder_end = inorder_end
            
            left_preorder_begin = preorder_begin + 1
            left_preorder_end = preorder_begin + 1 + (delimiter - inorder_begin)
            
            right_preorder_begin = preorder_begin + 1 + (delimiter - inorder_begin)
            right_preorder_end = preorder_end
            
            root.left = traversal(preorder, left_preorder_begin, left_preorder_end, inorder, left_inorder_begin, left_inorder_end)
            root.right = traversal(preorder, right_preorder_begin, right_preorder_end, inorder, right_inorder_begin, right_inorder_end)
            
            return root
        
        if len(inorder) == 0 or len(preorder) == 0:
            return None
        return traversal(preorder, 0, len(preorder), inorder, 0, len(inorder))