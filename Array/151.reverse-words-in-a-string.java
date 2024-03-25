/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.trim().split("\\s+");
        StringBuilder sbd = new StringBuilder();
        for (int i = sArr.length - 1; i > 0; i--) {
            sbd.append(sArr[i]);
            sbd.append(" ");
        }
        sbd.append(sArr[0]);
        return sbd.toString();
    }
}
// @lc code=end
