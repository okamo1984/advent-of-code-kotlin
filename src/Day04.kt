fun main() {
    fun getThreshold(s: String) = s.split("-").map { it.toInt() }
    fun isContain(min1: Int, max1: Int, min2: Int, max2: Int): Boolean {
        if (min1 == min2 || max1 == max2) return true
        if (min1 < min2 && max1 >= max2) return true
        if (min2 < min1 && max2 >= max1) return true
        return false
    }

    fun part1() {
        var total = 0
        for (line in readInput("Day04")) {
            val pair = line.split(",")
            val (min1, max1) = getThreshold(pair[0])
            val (min2, max2) = getThreshold(pair[1])
            total += if (isContain(min1, max1, min2, max2)) 1 else 0
        }
        println(total)
    }

    println("part1")
    part1()

    fun isOverlap(min1: Int, max1: Int, min2: Int, max2: Int): Boolean {
        if (isContain(min1, max1, min2, max2)) return true
        if (min2 in (min1 + 1)..max1) return true
        if (min1 in (min2 + 1) .. max2) return true
        return false
    }
    fun part2() {
        var total = 0
        for (line in readInput("Day04")) {
            val pair = line.split(",")
            val (min1, max1) = getThreshold(pair[0])
            val (min2, max2) = getThreshold(pair[1])
            total += if (isOverlap(min1, max1, min2, max2)) 1 else 0
        }
        println(total)
    }

    println("part2")
    part2()
}