#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size())
            return false;
        vector<int> count(128);
        for(const int c : s) {
            ++count[c];
        }
        for(const int c : t) {
            if(--count[c] < 0) {
                return false;
            }
        }
        return true;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    cout << sol.isAnagram("namm", "man") << endl;
    cout << sol.isAnagram("nan", "man") << endl;
    cout << sol.isAnagram("nam", "man") << endl;
    return 0;
}
