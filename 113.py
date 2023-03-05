# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def traversal(root, remain_value: int):
            if remain_value == 0 and root.left == None and root.right == None:
                res.append(temp[:])
            if root.left == None and root.right == None:
                return
            if root.left:
                temp.append(root.left.val)
                traversal(root.left, remain_value - root.left.val)
                temp.pop()
            if root.right:
                temp.append(root.right.val)
                traversal(root.right, remain_value - root.right.val)
                temp.pop()
                
        
        res = []
        temp = []
        if root == None:
            return res
        temp.append(root.val)
        traversal(root, targetSum - root.val)
        return res
    
s = Solution()

n5_2 = TreeNode(5, None, None)
n1_2 = TreeNode(1, n5_2, None)
n2_2 = TreeNode(2, None, None)

n5 = TreeNode(5, None, n2_2)
n6 = TreeNode(6)
n8 = TreeNode(8)

n3 = TreeNode(3, n6, n1_2)
n4 = TreeNode(4, n8, None)
n2 = TreeNode(2, n4, n5)
n1 = TreeNode(1, n2, n3)
result = s.pathSum(n1, 10)
print(result)