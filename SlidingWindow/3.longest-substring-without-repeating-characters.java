
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        int l = 0;
        Set<Character> set = new HashSet<Character>();

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
// @lc code=end
