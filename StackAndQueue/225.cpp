#include <iostream>
#include <queue>

using namespace std;

class MyStack {
public:

    std::queue<int> q1;
    std::queue<int> q2;
    MyStack() {
        
    }
    
    void push(int x) {
        q1.push(x);
    }
    
    int pop() {
        int size = q1.size();
        if (q1.size() > 0) {
            for (int i = 0; i < size - 1; i++) {
                q2.push(q1.front());
                q1.pop();
            }
        }
        int res = q1.front();
        q1 = q2;
        while (!q2.empty())
            q2.pop();

        return res;
    }
    
    int top() {
        return q1.back();
    }
    
    bool empty() {
        return q1.empty();
    }
};

int main(int argc, char const *argv[])
{
    MyStack stack = MyStack();
    stack.push(1);
    stack.push(2);
    cout << stack.top();
    stack.push(3);
    cout << stack.top();
    stack.push(4);
    cout << stack.top();

    cout << stack.pop();
    cout << stack.top();

    return 0;
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */