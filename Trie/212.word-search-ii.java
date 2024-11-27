/*
* @lc app=leetcode id=212 lang=java
*
* [212] Word Search II
*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findHelper(board, i, j, m, n, root);
            }
        }

        return new ArrayList<>(res);
    }

    private void findHelper(char[][] board, int i, int j, int m, int n, Node node) {
        char c = board[i][j];
        int idx = c - 'a';
        if (c == '#' || node.children[idx] == null) {
            return;
        }
        node = node.children[idx];
        if (node.isEnd) {
            res.add(node.word);
        }

        board[i][j] = '#';
        if (i > 0) {
            findHelper(board, i - 1, j, m, n, node);
        }
        if (j > 0) {
            findHelper(board, i, j - 1, m, n, node);
        }
        if (i < m - 1) {
            findHelper(board, i + 1, j, m, n, node);
        }
        if (j < n - 1) {
            findHelper(board, i, j + 1, m, n, node);
        }
        board[i][j] = c;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Node();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
            cur.word = word;
        }
        return root;
    }

    private class Node {
        Node[] children;
        boolean isEnd;
        String word;
        Node() {
            children = new Node[26];
        }
    }
}
// @lc code=end
