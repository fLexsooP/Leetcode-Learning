/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int calcSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    // sol1: using set
    // public boolean isHappy(int n) {
    //     Set<Integer> set = new HashSet<>();
    //     while (!set.contains(n)) {
    //         if (n == 1) {
    //             return true;
    //         }
    //         set.add(n);
    //         n = calcSum(n);
    //     }
    //     return false;
    // }

    // sol2: using floyd's algo
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = calcSum(slow);
            fast = calcSum(fast);
            fast = calcSum(fast);
        } while (slow != fast);
        return slow == 1 ? true : false;
    }
}
// @lc code=end
