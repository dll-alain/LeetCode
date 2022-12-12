package indi.alain.leetcode.dynamicprogramming;

/**
 * 背包问题
 * @author d
 */
public class CrushStones {
    public int lastStoneWeight(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int weight : stones) {
            for (int j = target; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + weight);
            }
        }
        return sum - 2 * dp[target];
    }


    public static void main(String[] args) {
        int a = 7;
        int b = 7;
        System.out.println(a >>= 2);
        System.out.println(b >>= 1);
    }
}
