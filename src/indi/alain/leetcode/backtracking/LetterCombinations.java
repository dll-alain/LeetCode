package indi.alain.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    class Solution {
        private List<String> reslut = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return reslut;
            }
            String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            backTracking(phone, digits, 0);
            return reslut;

        }

        private void backTracking(String[] phone, String digits, int index) {
            if (index == digits.length()) {
                reslut.add(sb.toString());
                return;
            }
            String curStr = phone[digits.charAt(index) - '0'];
            for (int i = 0; i < curStr.length(); i++) {
                sb.append(curStr.charAt(i));
                backTracking(phone, digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }


    }

}
