#include <iostream>
#include <vector>

using namespace std;

class Node
{
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val)
    {
        val = _val;
    }

    Node(int _val, vector<Node *> _children)
    {
        val = _val;
        children = _children;
    }
};
class Solution
{
public:
    int maxDepthHelper(Node *root)
    {
        if (root == NULL)
            return 0;
        int depth = 0;
        for (int i = 0; i < root->children.size(); i++)
        {
            depth = max(depth, maxDepthHelper(root->children[i]));
        }
        return depth;
    }
    int maxDepth(Node *root)
    {
        return maxDepthHelper(root);
    }
};