#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> umap; // array value as map key, array index as map value 
        for (int i = 0; i < nums.size(); i++) {
            if(umap.count(target - nums[i])) {
                return {umap[target - nums[i]], i};
            }
            umap.insert({nums[i], i});
        }
    }
};

