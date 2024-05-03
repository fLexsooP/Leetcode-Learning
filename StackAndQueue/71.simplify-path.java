/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
import java.util.Stack;

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : pathArray) {
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}
// @lc code=end
