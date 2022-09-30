#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        vector<int> res(nums.size(), 0);
        int k = nums.size() - 1;
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                res[k--] = nums[left] * nums[left];
                left++;
            } else {
                res[k--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    vector<int> nums = {-3, -1, 0, 2, 5, 9};
    auto res = sol.sortedSquares(nums);
    for (auto &&num : res)
    {
        cout << num << ' ';
    }
    
    return 0;
}
