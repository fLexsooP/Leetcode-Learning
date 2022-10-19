#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            while (!dq.empty() && nums[i] > dq.back())
                dq.pop_back();
            dq.push_back(nums[i]);
            if (i >= k && nums[i - k] == dq.front())
                dq.pop_front();
            if (i >= k - 1)
                ans.push_back(dq.front());
        }
        return ans;
    }
};

int main(int argc, char const *argv[])
{
    Solution s = Solution();
    vector<int> nums {1,3,-1,-3,5,3,6,7};
    vector<int> sol = s.maxSlidingWindow(nums, 3);
    for (auto && s : sol)
    {
        cout << s << ' ';
    }
    return 0;
}
