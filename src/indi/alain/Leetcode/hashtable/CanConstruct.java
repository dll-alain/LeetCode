package indi.alain.Leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author d
 * @date 20220529
 */
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对于英文字母之类的右规律字符，用数组代替HashMap能够节省时间和空间
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructArray(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
            if (record[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean res = canConstruct(ransomNote, magazine);
    }
}
