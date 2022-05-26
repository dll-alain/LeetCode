package indi.alain.Leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组是否有相同的元素
 * @author dll
 * @date 20220525
 */
public class InterSection {
    public int[] interSection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) {
            res[index++] = i;
        }
        return res;
    }
}
