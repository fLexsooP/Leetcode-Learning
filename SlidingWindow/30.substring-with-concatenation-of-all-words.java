
/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int numWord = words.length;
        int wordSize = words[0].length();
        int seqSize = wordSize * numWord;
        Map<String, Integer> freq = new HashMap<>();
        Map<String, Integer> curFreq;

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println(freq);

        for (int i = 0; i < wordSize; i++) {
            curFreq = new HashMap<>(freq);
            int count = 0;
            for (int j = i; j <= n - wordSize; j += wordSize) {
                String curWord = s.substring(j, j + wordSize);
                curFreq.put(curWord, curFreq.getOrDefault(curWord, 0) - 1);
                if (curFreq.containsKey(curWord) && curFreq.get(curWord) >= 0) {
                    count++;
                }

                int popIndex = j - seqSize;
                if (popIndex >= 0) {
                    String popWord = s.substring(popIndex, popIndex + wordSize);
                    curFreq.put(popWord, curFreq.get(popWord) + 1);
                    if (curFreq.get(popWord) > 0) {
                        count--;
                    }
                }

                if (count == numWord) {
                    res.add(popIndex + wordSize);
                }

            }
        }
        return res;
    }
}
// @lc code=end
