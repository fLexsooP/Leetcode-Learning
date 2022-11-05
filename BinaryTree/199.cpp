#include <iostream>
#include <vector>
#include <queue>

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
    vector<int> rightSideView(TreeNode* root)
    {
        queue<TreeNode*> q;
        vector<int> res;
        if (root != NULL)
            q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            TreeNode* cur;
            while (size--)
            {
                cur = q.front();
                q.pop();
                if (cur->left)
                    q.push(cur->left);
                if (cur->right)
                    q.push(cur->right);
            }
            res.push_back(cur->val);
        }
        return res;
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
        2				3
    4       5       6       7
    */
    Solution s = Solution();
    vector<int> vec = s.rightSideView(&node);
    for (auto &&n : vec)
    {
        cout << n;
    }
    return 0;
}