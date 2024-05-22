/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode traversal(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);

        int delimeter = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == cur.val) {
                delimeter = i;
            }
        }

        cur.left = traversal(preorder, preStart + 1, preStart + delimeter - inStart + 1,
                            inorder, inStart, delimeter);
        cur.right = traversal(preorder, preStart + delimeter - inStart + 1, preEnd,
                            inorder, delimeter + 1, inEnd);

        return cur;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}
// @lc code=end
