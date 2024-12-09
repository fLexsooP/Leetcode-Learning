package Math;
import java.util.Collections;
/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end
