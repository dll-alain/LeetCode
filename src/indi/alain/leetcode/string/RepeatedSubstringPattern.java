package indi.alain.leetcode.string;

/**
 * KMP 重复字符串
 * @author d
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] next = new int[s.length()];
        next = getNext(s);
        int len = next.length;
        if (next[len - 1] > 0 && (len % (len - next[len - 1])) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < s.length(); i ++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
