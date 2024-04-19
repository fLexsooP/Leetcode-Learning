
/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split("\\s+");
        if (pattern.length() != sArr.length) {
            return false;
        }

        int n = pattern.length();
        int[] pMap = new int[128];
        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char p = pattern.charAt(i);
            String word = sArr[i];
            if (!wordMap.containsKey(word) && pMap[p] != 0
                    || wordMap.containsKey(word) && wordMap.get(word) != pMap[p]) {
                return false;
            } else {
                pMap[p] = i + 1;
                wordMap.put(word, i + 1);
            }
        }
        return true;
    }
}
// @lc code=end
