/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int maxSum = Integer.MIN_VALUE;

    int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(pathSum(root.left), 0);
        int rightGain = Math.max(pathSum(root.right), 0);

        int curSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, curSum);

        return root.val + Math.max(leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
}
// @lc code=end
