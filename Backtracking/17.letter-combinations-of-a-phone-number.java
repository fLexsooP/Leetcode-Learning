
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    private String[] numMap = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> res = new ArrayList<>();

    private void recHelper(String digits, int index, String curStr) {
        if (index == digits.length()) {
            res.add(curStr);
            return;
        }
        String letters = numMap[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            recHelper(digits, index + 1, curStr + letters.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        recHelper(digits, 0, "");
        return res;
    }
}
// @lc code=end
