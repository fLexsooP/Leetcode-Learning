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
    // recursive
    void levelOrderHelper(TreeNode *root, vector<vector<int>> &res, int depth)
    {
        if (root == NULL)
            return;
        if (res.size() == depth)
            res.push_back(vector<int>());
        res[depth].push_back(root->val);
        levelOrderHelper(root->left, res, depth + 1);
        levelOrderHelper(root->right, res, depth + 1);
    }
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> res;
        int depth = 0;
        levelOrderHelper(root, res, depth);
        return res;
    }

    // iterative
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        queue<TreeNode *> q;
        vector<vector<int>> res;
        if (root != NULL)
            q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            vector<int> curLevel;
            for (int i = 0; i < size; i++)
            {
                TreeNode *node = q.front();
                q.pop();
                curLevel.push_back(node->val);
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }
            res.push_back(curLevel);
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
        2               3
    4       5       6       7
    */
    Solution s = Solution();
    vector<vector<int>> vec = s.levelOrder(&node);

    cout << '[';
    for (auto &&n : vec)
    {
        cout << '[';
        for (auto &&v : n)
        {
            cout << v << ' ';
        }
        cout << ']';
    }
    cout << ']';
    return 0;
}
