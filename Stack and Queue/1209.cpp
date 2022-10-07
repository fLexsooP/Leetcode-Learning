#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    string removeDuplicates(string s, int k) {
        std::vector<pair<char, int>> stack;
        for (auto && ch : s) {
            if (stack.empty() || stack.back().first != ch)
            {
                stack.emplace_back(ch, 1);
            } else if (++stack.back().second == k) {
                stack.pop_back();
            }
        }
        string res = "";
        for (auto && p : stack)
        {
            res.append(p.second,p.first);
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    cout << sol.removeDuplicates("ahhhaaddbccsssc", 3) << endl;
    return 0;
}
