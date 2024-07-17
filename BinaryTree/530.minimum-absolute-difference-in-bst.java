/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    int minVal = Integer.MAX_VALUE;
    TreeNode prev = null;

    void getMin(TreeNode cur) {
        if (cur == null) {
            return;
        }
        getMin(cur.left);
        if (prev != null) {
            minVal = Math.min(minVal, cur.val - prev.val);
        }
        prev = cur;
        getMin(cur.right);
    }

    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return minVal;
    }
}
// @lc code=end
