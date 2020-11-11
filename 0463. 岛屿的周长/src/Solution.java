/**
 * @author 废柴 2020/9/7 20:24
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0, x = grid.length; i < x; i++) {
            for (int j = 0, y = grid[i].length; j < y; j++) {
                if (grid[i][j] == 1) {
                    int edge = 0;
                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    if (i + 1 == x || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    if (j + 1 == y || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}
