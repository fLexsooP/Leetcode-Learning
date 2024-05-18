/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummySmall = new ListNode(0);
        ListNode dummyGreat = new ListNode(0);
        ListNode small = dummySmall;
        ListNode great = dummyGreat;
        while(head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }

        small.next = dummyGreat.next;
        great.next = null;
        return dummySmall.next;
    }
}
// @lc code=end
