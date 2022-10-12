package indi.alain.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dll
 * @date 20220526
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    /**
     * 获取每个位上数字
     * @param n
     * @return
     */
    public int getNextNum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    /**
     * 思路不够系统
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet();
        int res = 0;
        int temp = 0;
        int index = n;
        while (index != 1) {
            int len = (index + "").length();
            for (int i = 0; i < len; i++) {
                temp = (index /((int) Math.pow(10, i))) % 10;
                res += Math.pow(temp, 2);
            }
            if (!set.contains(res)) {
                set.add(res);
            } else {
                return false;
            }
            index = res;
            temp = 0;
            res = 0;
        }
        return true;
    }
}
