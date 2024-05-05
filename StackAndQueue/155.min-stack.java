
/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// @lc code=start
// regular sol
// class MinStack {
//     private Stack<Integer> stack = new Stack<>();
//     private List<Integer> minValList = new ArrayList<>();

//     public MinStack() {

//     }

//     public void push(int val) {
//         stack.push(val);
//         if (minValList.isEmpty()) {
//             minValList.add(val);
//         } else {
//             int prevMin = minValList.get(minValList.size() - 1);
//             minValList.add(val < prevMin ? val : prevMin);
//         }
//     }

//     public void pop() {
//         stack.pop();
//         minValList.remove(minValList.size() - 1);
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() {
//         return minValList.get(minValList.size() - 1);
//     }
// }

// genius sol
class MinStack {
    private class Node {
        int val;
        int minVal;
        Node next;

        public Node(int val, int minVal, Node next) {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }

    private Node node;
    public MinStack() {

    }

    public void push(int val) {
        if (node == null) {
            node = new Node(val, val, null);
        } else {
            node = new Node(val, Math.min(val, node.minVal), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
