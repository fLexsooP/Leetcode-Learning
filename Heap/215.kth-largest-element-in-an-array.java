/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
import java.util.Comparator;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap: O(nlogn) TC
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
// @lc code=end
