/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    int n = 1;
    int res;

    void traversal(TreeNode cur, int k) {
        if (cur == null) {
            return;
        }
        traversal(cur.left, k);
        if (n == k) {
            res = cur.val;
        }
        if (n > k) {
            return;
        }
        n++;
        traversal(cur.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }
}
// @lc code=end
