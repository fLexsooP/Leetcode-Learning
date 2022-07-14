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
    ListNode* swapPairs(ListNode* head) {
        
        ListNode* dummyHead = new ListNode(0, head);
        ListNode* prev = dummyHead;
        while(prev->next && prev->next->next) {
            ListNode* cache = prev->next->next;
            prev->next->next = cache->next;
            cache->next = prev->next;
            prev->next = cache;
            prev = cache->next;
        }
        return dummyHead->next;
    }
};
