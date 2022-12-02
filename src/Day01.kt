fun main() {
    println("part1")

    fun part1() {
        // https://kotlination.com/read-file-kotlin/
        var max = 0
        var candidate = 0
        for (line in readInput("Day01")) {
            if (line != "") {
                candidate += line.toInt()
                continue
            }
            if (candidate > max) {
                max = candidate
            }
            candidate = 0
        }
        println(max)
    }

    part1()

    println("part2")

    fun part2() {
        val calories = mutableListOf<Int>()
        var sum = 0
        for (line in readInput("Day01")) {
            if (line != "") {
                sum += line.toInt()
            } else {
                calories.add(sum)
                sum = 0
            }
        }
        val top3 = calories.sortedDescending().slice(0..2)
        println(top3.sum())
    }

    part2()
}
