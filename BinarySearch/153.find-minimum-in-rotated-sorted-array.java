/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        int minVal = Integer.MAX_VALUE;

        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            minVal = Math.min(minVal, nums[mid]);
        }
        return Math.min(minVal, nums[mid]);
    }
}
// @lc code=end
