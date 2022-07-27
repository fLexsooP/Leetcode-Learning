#include<iostream>
#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size(); i++) {
            // TODO:
        }
        
        return{nums};
    }
};
int main(int argc, char const *argv[])
{
    Solution sol;
    vector<int> nums{-5, 2, 4, -3, 8, -6, 7};
    vector<vector<int>> res = sol.threeSum(nums);
    for (auto const vec : res)
    {
        for (auto const v : vec)
        {
            cout << v << ' ';
        }
        cout << endl;
        
    }
    
    return 0;
}

