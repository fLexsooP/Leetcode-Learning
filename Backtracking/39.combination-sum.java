/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void helper(int[] candidates, int target, int curSum, int curIndex) {
        if (curSum == target) {
            res.add(new ArrayList(path));
            return;
        } else if (curSum > target) {
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            helper(candidates, target, curSum + candidates[i], i);
            path.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0);
        return res;
    }
}
// @lc code=end
