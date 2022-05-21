package indi.alain.Leetcode.hashtable;

import java.util.Arrays;

/**
 * @author dll
 * @date 20220521
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        boolean flag = true;
        for (char c : s.toCharArray()) {
            record[c % 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c % 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
