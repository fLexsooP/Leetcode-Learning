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
    bool isSymmetric(TreeNode* root) {
        return isSymm(root, root);
    }
    bool isSymm(TreeNode* l, TreeNode* r)
    {
        if (l == NULL || r == NULL)
            return l == r;
        return l->val == r->val && isSymm(l->left, r->right) && isSymm(l->right, r->left);
    }
};
int main(int argc, char const *argv[])
{
    TreeNode node = TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(2);
    node.left->left = new TreeNode(4);
    node.left->right = new TreeNode(5);
    node.right->left = new TreeNode(5);
    node.right->right = new TreeNode(4);
    /*
                1
        2				2
    4       5       5       4
    */
    Solution s = Solution();
    cout << s.isSymmetric(&node);
    return 0;
}