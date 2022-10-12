package indi.alain.leetcode.string;

/**
 * @author d
 */
public class ReverseString {
    /**
     * 按位亦或交换两个数
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right;
        for (right = s.length - 1;left < s.length / 2; left++) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            right--;
        }
    }
}
