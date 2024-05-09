/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curNode = dummy;
        int curTotal = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            curTotal += carry;
            if (l1 != null) {
                curTotal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curTotal += l2.val;
                l2 = l2.next;
            }
            
            carry = curTotal < 10 ? 0 : 1;
            curNode.next = new ListNode(curTotal %= 10);
            curNode = curNode.next;
            curTotal = 0;
        }
        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return dummy.next;
    }
}
// @lc code=end
