
/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
import java.util.Map;

// @lc code=start

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000);

        int n = s.length();
        int prevValue = map.get(String.valueOf(s.charAt(n - 1)));
        int res = prevValue;
        for (int i = n - 2; i >= 0; i--) {
            int currValue = map.get(String.valueOf(s.charAt(i)));
            if (currValue < prevValue) {
                res -= currValue;
            } else {
                res += currValue;
            }
            prevValue = currValue;
        }
        return res;
    }
}
// @lc code=end
