/**
 * @author 废柴 2020/9/15 15:02
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final char BLANK = '.';
    private static final char[] NUMS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int SIZE = 9;
    private static final int[] bucket = new int[SIZE];

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int x, int y) {
        if (x == SIZE) {
            return true;
        }
        if (board[x][y] == BLANK) {
            for (char num : NUMS) {
                board[x][y] = num;
                if (isUnique(board, x, y)) {
                    int nx = x, ny = y + 1;
                    if (ny == SIZE) {
                        nx++;
                        ny = 0;
                    }
                    if (solveSudoku(board, nx, ny)) {
                        return true;
                    }
                }
                board[x][y] = BLANK;
            }
        } else {
            int nx = x, ny = y + 1;
            if (ny == SIZE) {
                nx++;
                ny = 0;
            }
            return solveSudoku(board, nx, ny);
        }
        return false;
    }

    private boolean isUnique(char[][] board, int i, int j) {
        // 横
        clearBucket();
        for (int k = 0; k < SIZE; k++) {
            if (board[i][k] == BLANK) {
                break;
            }
            int index = board[i][k] - '1';
            if (bucket[index] == 1) {
                return false;
            }
            bucket[index] = 1;
        }
        // 竖
        clearBucket();
        for (int k = 0; k < SIZE; k++) {
            if (board[k][j] == BLANK) {
                break;
            }
            int index = board[k][j] - '1';
            if (bucket[index] == 1) {
                return false;
            }
            bucket[index] = 1;
        }
        // 块
        clearBucket();
        int is = i / 3 * 3, ie = is + 3, js = j / 3 * 3, je = js + 3;
        for (int ii = is; ii < ie; ++ii) {
            for (int jj = js; jj < je; ++jj) {
                if (board[ii][jj] == BLANK) {
                    return true;
                }
                int index = board[ii][jj] - '1';
                if (bucket[index] == 1) {
                    return false;
                }
                bucket[index] = 1;
            }
        }
        return true;
    }

    private void clearBucket() {
        for (int i = 0; i < SIZE; i++) {
            bucket[i] = 0;
        }
    }

    public static void main(String[] args) {
        char[][] board =
//                new char[][]{
//                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                };
                new char[][]{
                        {'.', '.', '.', '2', '.', '.', '.', '6', '3'},
                        {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
                        {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
                        {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
                        {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
                        {'4', '7', '.', '.', '.', '1', '.', '.', '.'}
                };
        long start = System.currentTimeMillis();
        new Solution().solveSudoku(board);
        System.out.println(System.currentTimeMillis() - start);
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
