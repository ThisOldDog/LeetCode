class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        var left = 0
        var right = 999999
        var min = 500000
        val deque = ArrayDeque<IntArray>(heights.size * heights.size)
        if (heights.size == 1 && heights[0].size == 1) {
            return 0
        }
        while (true) {
            deque.clear()
            deque.add(intArrayOf(0, 0))
            var find = false
            val visit = Array(heights.size) {
                BooleanArray(heights[0].size)
            }
            while (deque.isNotEmpty() && !find) {
                val first = deque.removeFirst()
                for (dir in dirs) {
                    val x = dir[0] + first[0]
                    val y = dir[1] + first[1]
                    if (x >= 0 && x < heights.size && y >= 0 && y < heights[0].size && !visit[x][y] && Math.abs(heights[x][y] - heights[first[0]][first[1]]) <= min) {
                        visit[x][y] = true
                        deque.addLast(intArrayOf(x, y))
                        if (x == heights.size - 1 && y == heights[0].size - 1) {
                            find = true
                        }
                    }
                }
            }
            if (find) {
                right = min
                val next = (left + right) / 2
                if (left >= right) {
                    return min
                }
                min = next
            } else {
                left = min
                val next = (left + right  + 1) / 2
                if (left >= right - 1) {
                    return left + 1
                }
                min = next
            }
        }
    }
}

fun main() {
    val solution = Solution()
    // [[1,2,2],[3,8,2],[5,3,5]] ==> 2
    println(
        solution.minimumEffortPath(
            arrayOf(
                intArrayOf(1, 2, 2),
                intArrayOf(3, 8, 2),
                intArrayOf(5, 3, 5),
            )
        )
    )
    // [[1,2,3],[3,8,4],[5,3,5]] ==> 1
    println(
        solution.minimumEffortPath(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(3, 8, 4),
                intArrayOf(5, 3, 5),
            )
        )
    )
    // [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]] ==> 0
    println(
        solution.minimumEffortPath(
            arrayOf(
                intArrayOf(1, 2, 1, 1, 1),
                intArrayOf(1, 2, 1, 2, 1),
                intArrayOf(1, 2, 1, 2, 1),
                intArrayOf(1, 2, 1, 2, 1),
                intArrayOf(1, 1, 1, 2, 1),
            )
        )
    )
}