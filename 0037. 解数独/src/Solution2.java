import java.util.BitSet;

/**
 * @author 废柴 2020/9/15 15:02
 */
@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private final char BLANK = '.';
    private final char[] NUMS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final int SIZE = 9;
    private final boolean[][] row = new boolean[SIZE][SIZE];
    private final boolean[][] column = new boolean[SIZE][SIZE];
    private final boolean[][] block = new boolean[SIZE][SIZE];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != BLANK) {
                    int index = board[i][j] - '1';
                    row[i][index] = column[j][index] = block[i / 3 * 3 + j / 3][index] = true;
                }
            }
        }
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int x, int y) {
        if (x == SIZE) {
            return true;
        }
        if (board[x][y] == BLANK) {
            for (char num : NUMS) {
                if (isUnique(num, x, y)) {
                    board[x][y] = num;
                    int nx = x, ny = y + 1;
                    if (ny == SIZE) {
                        nx++;
                        ny = 0;
                    }
                    if (solveSudoku(board, nx, ny)) {
                        return true;
                    }
                }
                if (board[x][y] != BLANK) {
                    clearBucket(board[x][y], x, y);
                    board[x][y] = BLANK;
                }
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

    private boolean isUnique(char num, int i, int j) {
        int index = num - '1';
        int blockIndex = i / 3 * 3 + j / 3;
        boolean unique = !row[i][index] && !column[j][index] && !block[blockIndex][index];
        if (unique) {
            row[i][index] = column[j][index] = block[blockIndex][index] = true;
        }
        return unique;
    }

    private void clearBucket(char num, int i, int j) {
        int index = num - '1';
        row[i][index] = column[j][index] = block[i / 3 * 3 + j / 3][index] = false;
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
        new Solution2().solveSudoku(board);
        System.out.println(System.currentTimeMillis() - start);
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
