/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] sbds = new StringBuilder[numRows];
        for (int i = 0; i < sbds.length; i++) {
            sbds[i] = new StringBuilder();
        }

        boolean dir = true;
        int currRow = 0;

        for (int i = 0; i < s.length(); i++) {
            sbds[currRow].append(s.charAt(i));
            if (dir) {
                currRow++;
            } else {
                currRow--;
            }
            if (currRow == 0 || currRow % (numRows - 1) == 0) {
                dir = !dir;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sbd : sbds) {
            res.append(sbd);
        }
        return res.toString();
    }
}
// @lc code=end
