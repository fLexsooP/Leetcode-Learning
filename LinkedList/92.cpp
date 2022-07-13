/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(!head || left >= right) {
            return head;
        }
        ListNode* dummyHead = new ListNode(0, head);
        ListNode* prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev->next;
        }
        ListNode* tail = prev->next;
        for(int i = left; i < right; i++) {
            ListNode* cache = tail->next;
            tail->next = cache->next;
            cache->next = prev->next;
            prev->next = cache;
        }
        return dummyHead->next;
    }
};