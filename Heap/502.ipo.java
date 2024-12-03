/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// @lc code=start
class Solution {
    class Product {
        int profit;
        int capital;
        Product(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            products[i] = new Product(profits[i], capital[i]);
        }
        Arrays.sort(products, (p1, p2) -> p1.capital - p2.capital);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // store the available profit in max heap
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < n && products[ptr].capital <= w) {
                pq.add(products[ptr].profit);
                ptr++;
            }
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll();
        }

        return w;
    }
}
// @lc code=end
