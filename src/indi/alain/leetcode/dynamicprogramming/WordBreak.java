package indi.alain.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author d
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j && !dp[j]; i++) {
                if (set.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
