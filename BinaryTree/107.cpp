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
    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        vector<vector<int>> res;
        int depth = 0;
        levelOrderBottomHelper(root, res, depth);
        reverse(res.begin(), res.end());
        return res;
    }
    void levelOrderBottomHelper(TreeNode *root, vector<vector<int>> &res, int depth)
    {
        if (root == NULL)
            return;
        if (res.size() == depth)
            res.push_back(vector<int>());
        res[depth].push_back(root->val);
        levelOrderBottomHelper(root->left, res, depth + 1);
        levelOrderBottomHelper(root->right, res, depth + 1);
    }

    //iterative
    vector<vector<int>> levelOrderBottomItr(TreeNode *root)
    {
        queue<TreeNode*> q;
        vector<vector<int>> res;
        if (root != NULL)
            q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            vector<int> curLv;
            for (int i = 0; i < size; i++)
            {
                TreeNode * cur = q.front();
                q.pop();
                curLv.push_back(cur->val);
                if (cur->left)
                    q.push(cur->left);
                if (cur->right)
                    q.push(cur->right);
            }
            res.push_back(curLv);
        }
        reverse(res.begin(), res.end());
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
    vector<vector<int>> vec = s.levelOrderBottomItr(&node);

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
