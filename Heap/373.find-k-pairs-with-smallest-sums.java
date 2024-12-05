
/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        pq.add(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair(0, 0));

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] entry = pq.poll();
            int i = entry[1];
            int j = entry[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !visited.contains(new Pair(i + 1, j))) {
                pq.add(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair(i + 1, j));
            }
            if (j + 1 < nums2.length && !visited.contains(new Pair(i, j + 1))) {
                pq.add(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair(i, j + 1));
            }
        }
        return res;
    }

    // Define own Pair class
    // class Couple {
    //     int x;
    //     int y;
    //     Couple(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(x, y);
    //     }

    //     @Override
    //     public boolean equals(Object o) {
    //         if (o instanceof Couple) {
    //             Couple c = (Couple) o;
    //             return (x == c.x) && (y == c.y);
    //         }
    //         return false;
    //     }
    // }

    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    //     Set<Couple> visited = new HashSet<>();

    //     pq.add(new int[] {nums1[0] + nums2[0], 0, 0});
    //     visited.add(new Couple(0, 0));

    //     List<List<Integer>> res = new ArrayList<>();
    //     while (k-- > 0 && !pq.isEmpty()) {
    //         int[] entry = pq.poll();
    //         int i = entry[1];
    //         int j = entry[2];

    //         res.add(Arrays.asList(nums1[i], nums2[j]));

    //         if (i + 1 < nums1.length && !visited.contains(new Couple(i + 1, j))) {
    //             pq.add(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
    //             visited.add(new Couple(i + 1, j));
    //         }
    //         if (j + 1 < nums2.length && !visited.contains(new Couple(i, j + 1))) {
    //             pq.add(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
    //             visited.add(new Couple(i, j + 1));
    //         }
    //     }
    //     return res;
    // }
}
// @lc code=end
