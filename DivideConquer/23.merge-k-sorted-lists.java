/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0) {
    //         return null;
    //     }

    //     PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    //     for (ListNode head: lists) {
    //         while (head != null) {
    //             pq.add(head);
    //             head = head.next;
    //         }
    //     }

    //     ListNode dummy = new ListNode(-1);
    //     ListNode cur = dummy;
    //     while (!pq.isEmpty()) {
    //         cur.next = pq.poll();
    //         cur = cur.next;
    //     }
    //     cur.next = null;
    //     return dummy.next;
    // }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        cur.next = l == null ? r : l;
        return dummy.next;
    }
}
// @lc code=end
