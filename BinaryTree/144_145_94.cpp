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
    vector<int> preorderTraversal(TreeNode *root)
    {
        vector<int> res;
        traversal(root, res);
        return res;
    }
    void traversal(TreeNode *cur, vector<int> &res)
    {
        if (cur == NULL)
            return;
        res.push_back(cur->val);
        traversal(cur->left, res);
        traversal(cur->right, res);
    }
};

int main(int argc, char const *argv[])
{
    TreeNode node = TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.left->left = new TreeNode(4);
    node.left->right = new TreeNode(5);
    node.right->left = new TreeNode(6);
    node.right->right = new TreeNode(7);
    /*
                1
        2               3
    4       5       6       7
    */

    Solution s = Solution();
    vector<int> vec = s.preorderTraversal(&node);
    for (auto &&n : vec)
    {
        cout << n;
    }

    return 0;
}
