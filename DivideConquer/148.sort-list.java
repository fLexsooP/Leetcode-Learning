/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l != null && r != null) {
            if (l.val < r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }

        if (l != null) {
            curr.next = l;
        }

        if (r != null) {
            curr.next = r;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // divide into 2 list
        ListNode slow = head;
        ListNode fast = head;
        ListNode leftEnd = new ListNode(0);
        leftEnd.next = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            leftEnd = leftEnd.next;
        }
        leftEnd.next = null;

        // sort
        ListNode l = sortList(head);
        ListNode r = sortList(slow);

        // merge
        return merge(l, r);
    }
}
// @lc code=end
