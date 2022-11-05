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
    vector<vector<int>> levelOrderItr(TreeNode *root)
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
        return res;
    }


    void makeBinaryTree(vector<int> input, TreeNode* root)
    {
        queue<TreeNode*> q;
        q.push(root);
        for (int i = 0; i < input.size(); i++)
        {
            TreeNode* cur = q.front();
            cur->val = input[i];
            cur->left = new TreeNode();
            cur->right = new TreeNode();
            q.push(cur->left);
            q.push(cur->right);
            q.pop();
        }
    }
};
int main(int argc, char const *argv[])
{
    Solution s = Solution();
    vector<int> input {1, 2, 3, 4, 5, 6, 7};
    TreeNode root = TreeNode(); 
    s.makeBinaryTree(input, &root);

    // TreeNode node = TreeNode(1);
    // node.left = new TreeNode(2);
    // node.right = new TreeNode(3);
    // node.left->left = new TreeNode(4);
    // node.left->right = new TreeNode(5);
    // node.right->left = new TreeNode(6);
    // node.right->right = new TreeNode(7);
    vector<vector<int>> res = s.levelOrderItr(&root);
    
    cout << "[";
    for (auto &&re : res)
    {
        cout << "[";
        for (auto &&r : re)
        {
            if (r == 0)
                cout << "null ";
            else
                cout << r << " ";
        }
        cout << "]";
    }
    cout << "]";
    return 0;
}