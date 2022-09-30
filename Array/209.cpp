#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int res = INT_MAX;
        int sum = 0;
        int len = 0;
        for (int left = 0, right = 0; right < nums.size(); right++) {
            sum += nums[right];
            while (sum >= target) {
                len = right - left + 1;
                res = len < res ? len : res;
                sum -= nums[left++];
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    vector<int> nums = {1, 5, 1, 2, 1, 2, 3, 3, 1, 5, };
    cout << sol.minSubArrayLen(7, nums) << endl;
    return 0;
}
