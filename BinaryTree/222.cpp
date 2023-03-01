#include <iostream>
#include <vector>


using namespace std;
// Definition for a binary tree node.
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right)
        : val(x), left(left), right(right) {}
};
class Solution
{
public:
    int countNodes(TreeNode* root) {
        if (root = 0)
            return NULL;
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        int leftLength = 0;
        int rightLength = 0;
        while (left)
        {
            left = left->left;
            leftLength++;
        }
        while (right)
        {
            right = right->right;
            rightLength++;
        }
        if (leftLength == rightLength) {
            return (2 << leftLength) - 1;
        }
        return coutnNodes(left) + countNodes(right) + 1;
    }
};