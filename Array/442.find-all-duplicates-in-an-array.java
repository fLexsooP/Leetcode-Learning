
/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);

            if (nums[number - 1] < 0) {
                res.add(number);
            } else {
                nums[number - 1] = -nums[number - 1];
            }
        }
        return res;
    }
}
// @lc code=end
