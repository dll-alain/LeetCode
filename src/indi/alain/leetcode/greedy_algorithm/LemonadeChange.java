package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5 -> five++;
                case 10 -> {
                    five--;
                    ten++;
                }
                case 20 -> {
                    if (ten > 0) {
                        five--;
                        ten--;
                    } else {
                        five -= 3;
                    }
                }

                default -> throw new IllegalStateException("Unexpected value: " + bills[i]);
            }
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }

}
