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
    int minDepth(TreeNode *root)
    {
        return minDepthHelper(root);
    }
    int minDepthHelper(TreeNode *root)
    {
        if(root == NULL)
            return 0;
        int leftDepth = minDepthHelper(root->left);
        int rightDepth = minDepthHelper(root->right);
        if (root->left != NULL && root->right == NULL)
        {
            return 1 + leftDepth;
        }
        if (root->right != NULL && root->left == NULL)
        {
            return 1 + rightDepth;
        }
        return 1 + min(leftDepth, rightDepth);
    }
};

int main(int argc, char const *argv[])
{
    TreeNode node = TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.left->left = new TreeNode(4);
    node.left->right = new TreeNode(5);
    // node.right->left = new TreeNode(6);
    // node.right->right = new TreeNode(7);
    /*
                1
        2				3
    4       5       6       7
    */
    Solution s = Solution();
    int res = s.minDepth(&node);
    cout << res << endl;
    return 0;
}