/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);
            // 23401
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // 01234 40123
                right = mid;
            }
        }
        return nums[left];
    }
}
// @lc code=end
