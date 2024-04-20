
/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String sig = String.valueOf(cArray);

            map.putIfAbsent(sig, new ArrayList<String>());
            map.get(sig).add(str);
        }

        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
// @lc code=end
