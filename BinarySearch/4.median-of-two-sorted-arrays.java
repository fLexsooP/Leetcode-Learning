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
        // int l1 = nums1.length;
        // int l2 = nums2.length;
        // int len = l1 + l2;
        // int target = len / 2;

        // int p1 = 0, p2 = 0;
        // int m1 = 0, m2 = 0;
        // while (target >= 0) {
        //     m2 = m1;

        //     if (p1 < l1 && p2 < l2) {
        //         if (nums1[p1] < nums2[p2]) {
        //             m1 = nums1[p1++];
        //         } else {
        //             m1 = nums2[p2++];
        //         }
        //     } else if (p1 < l1) {
        //         m1 = nums1[p1++];
        //     } else {
        //         m1 = nums2[p2++];
        //     }
        //     target--;
        // }

        // if (len % 2 == 1) {
        //     return m1;
        // }
        // return (m1 + m2) / 2.0;

        // Sol 3: Binary Search
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int target = n / 2;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = n1 - 1;

        while (true) {
            int i = (l + r) >> 1;
            int j = target - i - 2;

            int left1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int left2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            int right1 = i + 1 < n1 ? nums1[i + 1] : Integer.MAX_VALUE;
            int right2 = j + 1 < n2 ? nums2[j + 1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (n % 2 == 1) {
                    return Math.min(right1, right2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}
// @lc code=end
