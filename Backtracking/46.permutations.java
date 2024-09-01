/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    void helper(int[] nums, boolean isUsedNums[]) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsedNums[i]) {
                isUsedNums[i] = true;
                path.add(nums[i]);
                helper(nums, isUsedNums);
                isUsedNums[i] = false;
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUsedNums = new boolean[nums.length];
        helper(nums, isUsedNums);
        return res;
    }
}
// @lc code=end
