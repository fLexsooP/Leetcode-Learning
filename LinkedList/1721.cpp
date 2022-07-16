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
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* slow = dummy;
        ListNode* fast = dummy;
        for (int i = 0; i < k; i++) {
            fast = fast->next;
        }
        ListNode* left = fast;
        while (fast->next) {
            slow = slow->next;
            fast = fast->next;
        }
        ListNode* right = slow->next;
        int temp = right->val;
        right->val = left->val;
        left->val = temp;
        return dummy->next;
    }
};