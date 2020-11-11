import java.util.Arrays;

/**
 * @author 废柴 2020/10/6 10:37
 */
public class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] map = new int[N][N];
        int[] result = new int[N];
        for (int[] edge : edges) {
            // 计算子结点距离
            distance(map, edge[0], edge[1], 1, result);
            printMap(map);
        }
        return result;
    }

    private void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("--");
    }

    private void distance(int[][] map, int from, int to, int distance, int[] distanceSum) {
        System.out.printf("%d <-> %d : %d%n", from, to, distance);
        if (map[from][to] != 0 && map[from][to] <= distance) {
            return;
        }
//        System.out.printf("%d <-> %d : %d%n", from, to, distance);
        distanceSum[from] = distanceSum[from] - map[from][to] + distance;
        distanceSum[to] = distanceSum[to] - map[to][from] + distance;
        map[from][to] = map[to][from] = distance;
        for (int i = 0; i < map[to].length; i++) {
            if (map[to][i] != 0 && i != from) {
                distance(map, from, i, distance + map[to][i], distanceSum);
            }
        }
        for (int i = 0; i < map[from].length; i++) {
            if (map[from][i] != 0 && i != to) {
                distance(map, to, i, distance + map[from][i], distanceSum);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(new Solution().sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
//        System.out.println(Arrays.toString(new Solution().sumOfDistancesInTree(100, new int[][]{{74, 34}, {67, 44}, {81, 40}, {1, 97}, {44, 88}, {95, 23}, {77, 78}, {67, 29}, {98, 1}, {89, 3}, {60, 91}, {30, 28}, {64, 85}, {47, 72}, {64, 9}, {26, 35}, {24, 1}, {43, 35}, {62, 86}, {92, 86}, {59, 89}, {31, 3}, {31, 92}, {1, 33}, {54, 68}, {57, 63}, {2, 3}, {36, 64}, {6, 9}, {3, 67}, {99, 70}, {9, 47}, {45, 16}, {94, 92}, {22, 9}, {56, 31}, {89, 84}, {40, 31}, {37, 38}, {57, 52}, {75, 76}, {1, 26}, {65, 79}, {5, 39}, {96, 47}, {55, 14}, {83, 54}, {6, 32}, {11, 26}, {8, 40}, {32, 69}, {32, 14}, {78, 79}, {34, 92}, {31, 75}, {39, 45}, {3, 79}, {71, 31}, {82, 74}, {51, 58}, {27, 35}, {60, 70}, {31, 51}, {53, 74}, {64, 60}, {84, 90}, {39, 40}, {28, 80}, {0, 47}, {31, 41}, {1, 25}, {56, 48}, {93, 10}, {1, 17}, {37, 7}, {47, 15}, {49, 41}, {5, 18}, {4, 92}, {25, 64}, {84, 95}, {10, 95}, {63, 66}, {46, 87}, {92, 50}, {66, 3}, {64, 75}, {61, 98}, {78, 12}, {54, 71}, {7, 65}, {87, 39}, {73, 96}, {61, 20}, {64, 19}, {21, 69}, {30, 6}, {42, 72}, {13, 67}})));
        System.out.println(System.currentTimeMillis() - start);
    }
}
