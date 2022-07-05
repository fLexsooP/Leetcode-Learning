#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    Solution();
    
    int fruitsInBucket(vector<int> fruits) {
        int l = 0;
        int tree = 0;
        int len = 0;
        int ans = 0;
        int type1, type2;
        for (int r = 0; r < fruits.size(); r++) {
            if(tree == 0) {
                type1 = fruits[r];
                len++;
                tree++;
            } else if(tree == 1) {
                if(fruits[r] == type1) {
                    len++;
                } else {
                    type2 = fruits[r];
                    len++;
                    tree++;
                    l = r;
                }
            } else {
                if(fruits[r] == type1 || fruits[r] == type2) {
                    len++;
                    if(fruits[r] != fruits[r-1]) {
                        l = r;
                    }
                } else {
                    ans = ans > len ? ans : len;
                    len = r - l;
                    type1 = fruits[l];
                    tree = 1;
                    r--;
                }
            }
        }
        ans = ans > len ? ans : len;
        return ans;
    }
};


int main(int argc, char const *argv[])
{
    vector<int> fruits{1, 2, 3, 3, 2, 4};
    Solution s = Solution();
    int num = s.fruitsInBucket(fruits);
    cout << '[';
    for (int i = 0; i < fruits.size(); i++) {
        cout << fruits[i] << ',';
    }
    cout << ']' << endl;
    cout << num;
    return 0;
}
