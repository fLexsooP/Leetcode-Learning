/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int a = nums[0];
        int b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == b + 1) {
                b++;
            } else {
                if (a == b) {
                    res.add(Integer.toString(a));
                } else {
                    res.add(a + "->" + b);
                }
                a = nums[i];
                b = nums[i];
            }
        }
        if (a == b) {
            res.add(Integer.toString(a));
        } else {
            res.add(a + "->" + b);
        }
        return res;
    }
}
// @lc code=end
