/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stmap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stmap.containsKey(s.charAt(i))) {
                stmap.put(s.charAt(i), t.charAt(i));
            } else {
                if (stmap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }

            if (!tsMap.containsKey(t.charAt(i))) {
                tsMap.put(t.charAt(i), s.charAt(i));
            } else {
                if (tsMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[128];
        int[] tMap = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            } else {
                // can not be sMap[s.charAt(i)]++ since i has position info, ++ only check for number.
                sMap[s.charAt(i)] = i + 1;
                tMap[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}
// @lc code=end
