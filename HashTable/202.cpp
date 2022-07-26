#include<iostream>
using namespace std;

class Solution {
public:
    bool isHappy(int n) {
        int slow = getSum(n);
        int fast = getSum(getSum(n));
        while(slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return slow == 1;
    }

    int getSum(int n) {
        int sum = 0;
        while(n) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol;
    cout << sol.isHappy(19) << endl;
    cout << sol.isHappy(2) << endl;
    return 0;
}
