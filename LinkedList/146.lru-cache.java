/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
import java.util.HashMap;
import java.util.Map;

// @lc code=start
class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    // least recent used
    Node left = new Node(0, 0);
    // most recent used
    Node right = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node cur = cache.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node cur = new Node(key, value);
        cache.put(key, cur);
        insert(cur);

        if (cache.size() > this.capacity) {
            Node lru = this.left.next;
            cache.remove(lru.key);
            remove(lru);
        }

    }

    // remove cur node
    private void remove(Node cur) {
        Node l = cur.prev;
        Node r = cur.next;
        l.next = r;
        r.prev = l;
    }

    // insert cur node to most recent used side
    private void insert(Node cur) {
        Node l = this.right.prev;
        Node r = this.right;
        l.next = cur;
        r.prev = cur;
        cur.prev = l;
        cur.next = r;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
