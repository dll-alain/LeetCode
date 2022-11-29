package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] charArr = s.toCharArray();
        int flag = charArr.length;
        for (int i = charArr.length - 2; i >= 0; i--) {
            if (charArr[i] > charArr[i + 1]) {
                charArr[i]--;
                flag = i + 1;
            }
        }
        for (int i = flag; i < charArr.length; i++) {
            charArr[i] = '9';
        }
        return Integer.parseInt(String.valueOf(charArr));
    }
}
