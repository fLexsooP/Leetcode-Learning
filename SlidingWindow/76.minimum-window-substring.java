
/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int startIndex = 0;
        int minSize = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int count = t.length();
        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        while (r < s.length()) {
            // shift right, if current is taget char, decrease count
            char curChar = s.charAt(r);
            if (freq[curChar] > 0) {
                count--;
            }
            freq[curChar]--;
            r++;

            // once filled with all char in t, shift l left to find min length
            while (count == 0) {
                if (r - l < minSize) {
                    startIndex = l;
                    minSize = r - l;
                }

                // once pop a target char, increase count
                char curPop = s.charAt(l);
                if (freq[curPop] == 0) {
                    count++;
                }
                l++;
                freq[curPop]++;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minSize);
    }
}
// @lc code=end
