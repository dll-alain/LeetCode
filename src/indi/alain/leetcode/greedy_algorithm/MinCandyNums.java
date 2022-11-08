package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class MinCandyNums {
    public int candy(int[] ratings) {
        int[] candyNums = new int[ratings.length];
        //Arrays.fill(candyNums, 1);
        candyNums[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            // if (ratings[i] > ratings[i - 1]) {
            //     candyNums[i] = candyNums[i - 1] + 1;
            // }
            candyNums[i] = ratings[i] > ratings[i - 1] ? candyNums[i - 1] + 1 : 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyNums[i] = Math.max(candyNums[i], candyNums[i + 1] + 1);
            }
        }
        //return Arrays.stream(candyNums).sum();
        int result = 0;
        for (int n : candyNums) {
            result += n;
        }
        return result;
    }
}
