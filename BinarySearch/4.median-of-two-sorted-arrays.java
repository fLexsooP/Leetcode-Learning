/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Sol 1: Brute Force
        // int l1 = nums1.length;
        // int l2 = nums2.length;
        // int len = l1 + l2;
        // int[] nums = new int[len];
        // System.arraycopy(nums1, 0, nums, 0, l1);
        // System.arraycopy(nums2, 0, nums, l1, l2);
        // Arrays.sort(nums);

        // if (len % 2 == 1) {
        //     return nums[len / 2];
        // }
        // return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;

        // Sol 2: two pointer
        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        int target = len / 2;

        int p1 = 0, p2 = 0;
        int m1 = 0, m2 = 0;
        while (target >= 0) {
            m2 = m1;

            if (p1 < l1 && p2 < l2) {
                if (nums1[p1] < nums2[p2]) {
                    m1 = nums1[p1++];
                } else {
                    m1 = nums2[p2++];
                }
            } else if (p1 < l1) {
                m1 = nums1[p1++];
            } else {
                m1 = nums2[p2++];
            }
            target--;
        }

        if (len % 2 == 1) {
            return m1;
        }
        return (m1 + m2) / 2.0;
    }
}
// @lc code=end
