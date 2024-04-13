/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!freq.containsKey(c) || freq.get(c) <= 0) {
                return false;
            } else {
                freq.put(c, freq.get(c) - 1);
            }
        }
        return true;
    }
}
// @lc code=end
