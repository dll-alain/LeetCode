package indi.alain.Leetcode.string;

/**
 * KMP
 * @author dll
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }
        int[] next = getNext(needle);
        for (int i = 1, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == next.length) {
                return i - (j - 1);
            }
        }
        return -1;
    }

    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
