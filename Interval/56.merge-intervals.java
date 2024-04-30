/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(intervals[i][1], right);
            } else {
                res.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[] {left, right});
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
