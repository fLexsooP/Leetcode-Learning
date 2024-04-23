/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curSeq = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    curSeq++;
                    cur++;
                }
                res = Math.max(res, curSeq);
            }
        }

        return res;
    }
}
// @lc code=end
