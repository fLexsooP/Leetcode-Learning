#include<iostream>
#include<vector>
#include<unordered_set>
using namespace std;

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        unordered_set<int> nums(nums1.begin(), nums1.end());
        for (auto const num : nums2) {
            if(nums.erase(num)) {
                ans.push_back(num);
            }
        }
        return ans;
    }
};