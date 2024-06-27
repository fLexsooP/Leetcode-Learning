/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftLen = 0;
        int rightLen = 0;
        while (left != null) {
            leftLen++;
            left = left.left;
        }
        while (right != null) {
            rightLen++;
            right = right.right;
        }
        if (leftLen == rightLen) {
            return (int)Math.round(Math.pow(2, leftLen + 1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
// @lc code=end
