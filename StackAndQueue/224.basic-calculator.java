/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sign = 1;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                res += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += number * sign;
                res *= stack.pop();
                res += stack.pop();
                number = 0;
                sign = 1;
            }
        }
        res += number * sign;
        return res;
    }
}
// @lc code=end
