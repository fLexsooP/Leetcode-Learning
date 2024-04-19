/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[128];
        if (s.length() != t.length()) {
            return false;
        }
        
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (char c : t.toCharArray()) {
            map[c]--;
            if (map[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
