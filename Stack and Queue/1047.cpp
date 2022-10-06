#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    string removeDuplicates(string s) {
        std::stack<char> st;
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            if (st.empty() || s[i] != st.top())
                st.push(s[i]);
            else
                st.pop();
        }
        while (!st.empty()) {
            res += st.top();
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    cout << sol.removeDuplicates("assadbcssc") << endl;
    
    return 0;
}
