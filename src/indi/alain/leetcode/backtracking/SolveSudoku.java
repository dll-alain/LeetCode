package indi.alain.leetcode.backtracking;

/**
 * @author d
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    private boolean backTracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backTracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }


    private boolean isValid(int row, int column, char value, char[][] board) {
        //判断行是否有重复
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == value) {
                return false;
            }
        }
        //判断列是否有重复
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == value) {
                return false;
            }
        }
        //判断小9宫是否有重复
        int rowStart = (row / 3) * 3;
        int columnStart = (column / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}
