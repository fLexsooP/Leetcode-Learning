package Trie;
/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class WordDictionary {
    class Node {
        Node[] childrenNodes;
        boolean isEnd;

        Node() {
            childrenNodes = new Node[26];
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.childrenNodes[index] == null) {
                cur.childrenNodes[index] = new Node();
            }
            cur = cur.childrenNodes[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return backtracking(word, 0, root);
    }

    private boolean backtracking(String word, int index, Node cur) {
        if(index == word.length()) {
            return cur.isEnd;
        }

        int idx = word.charAt(index) - 'a';
        if (word.charAt(index) == '.') {
            for (Node child : cur.childrenNodes) {
                if (child != null && backtracking(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        if (cur.childrenNodes[idx] == null) {
            return false;
        }
        return backtracking(word, index + 1, cur.childrenNodes[idx]);

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
