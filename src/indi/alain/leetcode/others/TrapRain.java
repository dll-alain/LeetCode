package indi.alain.leetcode.others;

/**
 * @author d
 */
public class TrapRain {
    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) continue;

            int lheight = height[i]; //left heightest bar
            int rheight = height[i];

            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > lheight) lheight = height[j];
            }
            for (int j = i + 1; j < len; j++) {
                if (height[j] > rheight) rheight = height[j];
            }
            int h = Math.min(lheight, rheight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }
}
