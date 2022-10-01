#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        unordered_map<int, int> type;
        int len = 0;
        for (int left = 0, right = 0; right < fruits.size(); right++) {
            ++type[fruits[right]];
            while (type.size() > 2) {
                if (--type[fruits[left]] == 0)
                {
                    type.erase(fruits[left]);
                }
                left++;
            }
            len = max(len, right - left + 1);
        }
        return len;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    vector<int> nums = {3, 4, 3, 5, 5, 3, 2, 3, 1};
    cout << sol.totalFruit(nums) << endl;
    return 0;
}
