package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class PackageProblemTest {

    public static void testPackage(int[] weight, int[] value, int bagSize) {
        int numGoods = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[numGoods + 1][bagSize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= numGoods; i++) {
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= numGoods; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        for (int i = 0; i <= numGoods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void testPackageOneDim(int[] weight, int[] value, int bagSize) {
        int numGoods = weight.length;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < numGoods; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int i : dp) {
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testPackageOneDim(weight, value, bagSize);
    }
}
