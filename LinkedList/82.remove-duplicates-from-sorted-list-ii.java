/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        boolean flag = false;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                flag = true;
            } else if (flag) { // cur node used duplicate and need remove
                cur = cur.next;
                pre.next = cur;
                flag = false;
            } else { // cur node not duplicate
                pre = pre.next;
                cur = cur.next;
                flag = false;
            }
        }
        if (flag) { // last cur duplicate
            pre.next = cur.next;
        }

        return dummy.next;
    }
}
// @lc code=end
