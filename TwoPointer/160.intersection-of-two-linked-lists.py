#
# @lc app=leetcode id=160 lang=python3
#
# [160] Intersection of Two Linked Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        curA = headA
        curB = headB

        while curA:
            curA = curA.next
            lenA += 1

        while curB:
            curB = curB.next
            lenB += 1

        if lenA < lenB:
            headA, headB = headB, headA

        diff = abs(lenA - lenB)

        for _ in range(diff):
            headA = headA.next

        while headA:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None
# @lc code=end
