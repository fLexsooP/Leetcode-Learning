#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
 public:
  struct myComparison {
    bool operator()(const pair<int, int>& lhs, const pair<int, int>& rhs) {
      return lhs.first > rhs.first;
    }
  };

  vector<int> topKFrequent(vector<int>& nums, int k) {
    // first is number, second is frequency
    unordered_map<int, int> map;
    for (int num : nums) {
      map[num]++;
    }
    // create a min-heap. pair<first, second>: first is frequency, second is number
    priority_queue<pair<int, int>, vector<pair<int, int>>, myComparison> pq;

    for (auto it = map.begin(); it != map.end(); it++) {
      pq.emplace(it->second, it->first);
      if (pq.size() > k) {
        pq.pop();
      }
    }
    vector<int> res;
    while (!pq.empty()) {
      res.push_back(pq.top().second);
      pq.pop();
    }
    return res;
  }
};

int main(int argc, char const* argv[]) {
  Solution s = Solution();
  vector<int> nums{1, 3, 1, 5, 5, 3, 6, 7, 5, 3};
  vector<int> sol = s.topKFrequent(nums, 2);
  for (auto&& s : sol) {
    cout << s << ' ';
  }
  return 0;
}