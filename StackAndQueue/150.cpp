#include <iostream>
#include <vector>
#include <string>
#include <stack>

using namespace std;

class Solution {
public:
    int evalRPN(std::vector<string>& tokens) {
        stack<long long> st;
        for (string & i : tokens) {
            if (i == "+" || i == "-" || i == "*" || i == "/") {
                long long a = st.top();
                st.pop();
                long long b = st.top();
                st.pop();
                if (i == "+") {
                    st.push(b + a);
                } else if (i == "-") {
                    st.push(b - a);
                } else if (i == "*") {
                    st.push(b * a);
                } else if (i == "/") {
                    st.push(b / a);
                }
            } else {
                st.push(stoll(i));
            }
        }
        return st.top();
    }
};

int main(int argc, char const *argv[])
{
    Solution s = Solution();
    vector<string> tokens {"4","13","5","/","+"};
    cout << s.evalRPN(tokens) << endl;
    return 0;
}
