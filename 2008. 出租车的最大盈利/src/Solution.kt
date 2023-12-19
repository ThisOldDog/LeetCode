class Solution {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        val max = arrayOf(0L)
        rides.sortWith(compareBy({ it[0] }, { it[1] }, { -it[2] }))
        calculate(n, rides, 0L, max, 1, 0)
        return max[0]
    }

    fun calculate(
        n: Int,
        rides: Array<IntArray>,
        current: Long,
        max: Array<Long>,
        nIndex: Int,
        ridesIndex: Int
    ) {
        var ride = false
        var rideIndex = 0
        var _current = current
        var _ridesIndex = ridesIndex
        for (i in nIndex..n) {
            if (ride && rides[rideIndex][1] == i) {
                _current += rides[rideIndex][1] - rides[rideIndex][0] + rides[rideIndex][2]
                ride = false;
            }
            while (_ridesIndex < rides.size && rides[_ridesIndex][0] == i) {
                if (rides[_ridesIndex][1] >= rides[rideIndex][1]
                    && rides[_ridesIndex][0] == rides[rideIndex][0]
                    && ((rides[_ridesIndex][1] - rides[_ridesIndex][0] + rides[_ridesIndex][2]) <= (rides[ridesIndex][1] - rides[ridesIndex][0] + rides[ridesIndex][2]))) {
                    _ridesIndex++
                    continue
                }
                if (ride) {
                    calculate(n, rides, _current, max, i, _ridesIndex)
                } else {
                    ride = true
                    rideIndex = _ridesIndex
                }
                _ridesIndex++
            }
            if (i == n) {
                max[0] = if (max[0] > _current) max[0] else _current
                return
            }
        }
    }
}

fun main() {
    val solution = Solution()
//    println(
//        solution.maxTaxiEarnings(
//            5, arrayOf(
//                arrayOf(2, 5, 4).toIntArray(),
//                arrayOf(1, 5, 1).toIntArray()
//            )
//        )
//    )
//    println(
//        solution.maxTaxiEarnings(
//            20, arrayOf(
//                arrayOf(1, 6, 1).toIntArray(),
//                arrayOf(3, 10, 2).toIntArray(),
//                arrayOf(10, 12, 3).toIntArray(),
//                arrayOf(11, 12, 2).toIntArray(),
//                arrayOf(12, 15, 2).toIntArray(),
//                arrayOf(13, 18, 1).toIntArray()
//            )
//        )
//    )
    println(
        solution.maxTaxiEarnings(
            10, arrayOf(
                arrayOf(2, 3, 6).toIntArray(),
                arrayOf(8, 9, 8).toIntArray(),
                arrayOf(5, 9, 7).toIntArray(),
                arrayOf(8, 9, 1).toIntArray(),
                arrayOf(2, 9, 2).toIntArray(),
                arrayOf(9, 10, 6).toIntArray(),
                arrayOf(7, 10, 10).toIntArray(),
                arrayOf(6, 7, 9).toIntArray(),
                arrayOf(4, 9, 7).toIntArray(),
                arrayOf(2, 3, 1).toIntArray(),
            )
        )
    )
}