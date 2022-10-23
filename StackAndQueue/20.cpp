#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
        std::stack<char> stk;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '{' )
                stk.push('}');
            else if (s[i] == '[')
                stk.push(']');
            else if (s[i] == '(')
                stk.push(')');
            else if (stk.empty() || stk.top() != s[i])
                return false;
            else
                stk.pop();
        }
        return stk.empty();
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    cout << sol.isValid("{[]()}");
    return 0;
}
