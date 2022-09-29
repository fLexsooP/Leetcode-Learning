#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int i = 0;
        int j = 0;
        for (; i < nums.size(); i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                ++j;
            }
        }
        return j;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();
    vector<int> nums{-1, 20, 123, 15, 29, 123, 4, -9};
    cout << sol.removeElement(nums, 123) << endl; 
    return 0;
}
