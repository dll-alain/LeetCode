package indi.alain.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 */
public class NQueen {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chesshBoard = new char[n][n];
        for (char[] c : chesshBoard) {
            Arrays.fill(c, '.');
        }
        backTracking(0, n, chesshBoard);
        return result;
    }

    private List<String> Array2List(char[][] chesshBoard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chesshBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(int row, int column, char[][] chesshBoard, int n) {
        //检测同一列是否有两个Queen
        for (int i = row; i >= 0; --i) {
            if (chesshBoard[i][column] == 'Q') {
                return false;
            }
        }
        //检测45°
        for (int i = row, j = column; i >= 0 && j >= 0; --i, --j) {
            if (chesshBoard[i][j] == 'Q') {
                return false;
            }
        }
        //检测135°
        for (int i = row, j = column; i >= 0 && j <= n - 1; --i, ++j) {
            if (chesshBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void backTracking(int row, int n, char[][] chesshBoard) {
        if (row == n) {
            result.add(Array2List(chesshBoard));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(row, j, chesshBoard, n)) {
                chesshBoard[row][j] = 'Q';
                backTracking(row + 1, n, chesshBoard);
                chesshBoard[row][j] = '.';
            }
        }
    }

}
