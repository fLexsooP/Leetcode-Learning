
/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
import java.util.ArrayList;
import java.util.List;

// @lc code=start

class Solution {
    private String makeSpaces(int n) {
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append(" ");
        }
        return sbd.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        List<String> curLine = new ArrayList<String>();
        int curWidth = 0;
        int i = 0;

        while (i < words.length) {
            if (curWidth + curLine.size() + words[i].length() > maxWidth) {
                // processing the line, add spaces
                int spaces = maxWidth - curWidth;
                int spaceEach = spaces / Math.max(curLine.size() - 1, 1);
                int remainder = spaces % Math.max(curLine.size() - 1, 1);

                for (int j = 0; j < Math.max(curLine.size() - 1, 1); j++) {
                    curLine.set(j, curLine.get(j) + makeSpaces(spaceEach));
                    if (remainder > 0) {
                        curLine.set(j, curLine.get(j) + " ");
                        remainder--;
                    }
                }

                // combine current line and add to result
                StringBuilder s = new StringBuilder();
                for (int k = 0; k < curLine.size(); k++) {
                    s.append(curLine.get(k));
                }
                res.add(s.toString());

                // reset the line
                curLine.clear();
                curWidth = 0;
            }
            curLine.add(words[i]);
            curWidth += words[i].length();
            i++;
        }

        // handle last line
        int widthLeft = maxWidth - curWidth - curLine.size() + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int l = 0; l < curLine.size() - 1; l++) {
            stringBuilder.append(curLine.get(l) + " ");
        }
        stringBuilder.append(curLine.get(curLine.size() - 1));
        stringBuilder.append(makeSpaces(widthLeft));
        res.add(stringBuilder.toString());

        return res;
    }
}
// @lc code=end
