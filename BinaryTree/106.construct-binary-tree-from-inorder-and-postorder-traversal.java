/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    TreeNode traversal(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart == inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd - 1]);

        int delimeter = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == cur.val) {
                delimeter = i;
            }
        }

        cur.left = traversal(inorder, inStart, delimeter,
                            postorder, postStart, postStart + delimeter - inStart);
        cur.right = traversal(inorder, delimeter + 1, inEnd,
                            postorder, postStart + delimeter - inStart, postEnd - 1);

        return cur;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
}
// @lc code=end
