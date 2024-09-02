/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    public void helper(int n, int leftCount, int rightCount, String curStr) {
        if (rightCount == n) {
            res.add(curStr);
            return;
        }

        if (leftCount < n) {
            helper(n, leftCount + 1, rightCount, curStr + "(");
        }
        if (rightCount < leftCount) {
            helper(n, leftCount, rightCount + 1, curStr + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return res;
    }
}
// @lc code=end
