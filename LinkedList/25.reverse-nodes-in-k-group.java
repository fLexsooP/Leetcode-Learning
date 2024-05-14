/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode cur = head;
        int len = 0;
        while(cur != null) {
            cur = cur.next;
            len++;
        }
        int round = len / k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = dummy.next;
        ListNode fwrd = null;
        while(round > 0) {
            for (int i = 1; i < k; i++) {
                fwrd = end.next;
                end.next = fwrd.next;
                fwrd.next = prev.next;
                prev.next = fwrd;
            }
            prev = end;
            end = prev.next;
            round--;
        }
        return dummy.next;
    }
}
// @lc code=end
