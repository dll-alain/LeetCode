package indi.alain.leetcode.string;

/**
 * @author d
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(arr.length - 1, left + k - 1);
            while (left < right) {
                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
