/**
 * @author 废柴 2020/9/8 10:32
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area = areaOfIsland(grid, i, j, 0);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int i, int j, int area) {
        // 超出边界，或者为水域/已经计算过的面积
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return area;
        }
        // 计算面积
        if (grid[i][j] == 1) {
            area++;
            grid[i][j] = -1;
        }
        area = areaOfIsland(grid, i - 1, j, area);
        area = areaOfIsland(grid, i + 1, j, area);
        area = areaOfIsland(grid, i, j - 1, area);
        area = areaOfIsland(grid, i, j + 1, area);
        return area;
    }
}
