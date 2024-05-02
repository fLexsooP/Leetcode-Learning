/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c ) {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
// @lc code=end
