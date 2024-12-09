package Math;
/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        String str = String.valueOf(x);
        int m = 0;
        int n = str.length() - 1;

        while (m < n) {
            if (str.charAt(m) != str.charAt(n)) {
                return false;
            }
            m++;
            n--;
        }
        return true;
    }
}
// @lc code=end
