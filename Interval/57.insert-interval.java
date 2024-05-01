/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] mergedIntervals = new int[intervals.length + 1][];

        // option 1 : Using sort(), but O(nlogn)
        // for (int i = 0; i < intervals.length; i++) {
        //     mergedIntervals[i] = intervals[i];
        // }
        // mergedIntervals[mergedIntervals.length - 1] = newInterval;
        // Arrays.sort(mergedIntervals, (a, b) -> a[0] - b[0]);

        // option 2 : sort by hand with O(n)
        int j = 0;
        for (; j < intervals.length && intervals[j][0] < newInterval[0]; j++) {
                mergedIntervals[j] = intervals[j];
        }
        mergedIntervals[j] = newInterval;
        while (j < intervals.length) {
            mergedIntervals[j + 1] = intervals[j];
            j++;
        }

        // same with 56.merge-intervals
        List<int[]> res = new ArrayList<>();
        int left = mergedIntervals[0][0];
        int right = mergedIntervals[0][1];
        for (int i = 1; i < mergedIntervals.length; i++) {
            if (mergedIntervals[i][0] > right) {
                res.add(new int[] {left, right});
                left = mergedIntervals[i][0];
                right = mergedIntervals[i][1];
            } else {
                right = Math.max(right, mergedIntervals[i][1]);
            }
        }
        res.add(new int[] {left, right});
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end
