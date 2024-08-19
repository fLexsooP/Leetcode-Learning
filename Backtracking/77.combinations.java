/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }
}
// @lc code=end
