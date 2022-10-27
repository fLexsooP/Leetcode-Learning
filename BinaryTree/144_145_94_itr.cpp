#include <iostream>
#include <vector>
#include <stack>

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
        stack<TreeNode*> st;
        st.push(root);
        while (!st.empty())
        {
            TreeNode* node = st.top();
            st.pop();
            res.push_back(node->val);
            if (node->right)
                st.push(node->right);
            if (node->left)
                st.push(node->left);
        }
        return res;
    }
    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> res;
        stack<TreeNode *> st;
        st.push(root);
        while (!st.empty())             // m-r-l
        {
            TreeNode *node = st.top();
            st.pop();
            res.push_back(node->val);
            if (node->left)             // reverse order
                st.push(node->left);
            if (node->right)            // reverse order
                st.push(node->right);
        }
        reverse(res.begin(), res.end());// l-r-m
        return res;
    }
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> res;
        return res;
    };
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
                /       \
            2               3
          /    \           /  \
        4       5       6       7
        */
        Solution s = Solution();
        vector<int> vec = s.postorderTraversal(&node);
        for (auto &&n : vec)
        {
            cout << n;
        }

        return 0;
}
