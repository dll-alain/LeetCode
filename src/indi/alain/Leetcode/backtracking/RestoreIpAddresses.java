package indi.alain.Leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d
 */
public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        backTracking(s, 0, 0);
        return result;
    }

    private void backTracking(String s, int pointNum, int startIndex) {
        if (pointNum == 3) {
            if (isValie(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValie(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTracking(s, pointNum, i + 2);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private boolean isValie(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }

}
