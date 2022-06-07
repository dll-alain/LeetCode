package indi.alain.Leetcode.string;

/**
 * @author d
 * @date 20220607
 */
public class ReverseLeftString {

    //空间复杂度为O(1)
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    /**
     * 双指针法
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        int len = s.length();
        int left = 0;
        int right;
        char[] strArr = s.toCharArray();
        char[] result = new char[len];
        for (right = n; left < len; left++, right++) {
            if (right < len) {
                result[left] = strArr[right];
            } else {
                result[left] = strArr[right % len];
            }
        }
        return new String(result);
    }
}
