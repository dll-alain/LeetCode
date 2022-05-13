package indi.alain.Leetcode.onetoten;

import java.util.Arrays;

/**
 * @author dll
 */
public class GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int loop = n / 2;
        int num = 1;
        int count = 0;
        int j = 0;
        int i = 0;
        while (loop > 0) {
            while (j < n - 1 - count) {
                matrix[i][j++] = num++;
            }
            while (i < n - 1 - count) {
                matrix[i++][j] = num++;
            }
            while (j > count) {
                matrix[i][j--] = num++;
            }
            while (i > count) {
                matrix[i--][j] = num++;
            }
            count++;
            i = count;
            j = count;
            loop--;
        }
        if (n % 2 == 1) {
            matrix[n/2][n/2] = num;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] matrix = generateMatrix(n);
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
}
