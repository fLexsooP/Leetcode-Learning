/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        k = k % n;
        ListNode left = dummy;
        ListNode right = dummy;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        right.next = head;
        dummy.next = left.next;
        left.next = null;
        return dummy.next;
    }
}
// @lc code=end
