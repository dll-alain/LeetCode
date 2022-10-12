package indi.alain.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dll
 * @date 20220528
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sumab = i + j;
                if (map.containsKey(sumab)) {
                    map.put(sumab, map.get(sumab) + 1);
                } else {
                    map.put(sumab, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int sumcd = 0 - i - j;
                if (map.containsKey(sumcd)) {
                    res += map.get(sumcd);
                }
            }
        }
        return res;
    }
}
