/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;
        ListNode right = dummy;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right.next != null) {
            preLeft = preLeft.next;
            right = right.next;
        }

        preLeft.next = preLeft.next.next;
        return dummy.next;
    }
}
// @lc code=end
