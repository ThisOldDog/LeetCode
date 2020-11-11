import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 废柴 2020/9/7 20:03
 */
public class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point north() {
            return new Point(x, y + 1);
        }

        Point south() {
            return new Point(x, y - 1);
        }

        Point west() {
            return new Point(x - 1, y);
        }

        Point east() {
            return new Point(x + 1, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {
        Set<Point> map = new HashSet<>();
        Point point = new Point(0, 0);
        map.add(point);
        for (char d : path.toCharArray()) {
            if (d == 'N') {
                point = point.north();
            } else if (d == 'S') {
                point = point.south();
            } else if (d == 'W') {
                point = point.west();
            } else {
                point = point.east();
            }
            if (map.contains(point)) {
                return true;
            }
            map.add(point);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NESWW"));
    }
}
