fun main() {
    fun getPriority(char: Char) = if (char.isLowerCase()) {
        char.code - 96
    } else {
        char.code - 38
    }

    fun part1() {
        var total = 0
        for (line in readInput("Day03")) {
            val same = line
                .slice(0 until line.length / 2)
                .toSet()
                .intersect(line.slice(line.length / 2 until line.length).toSet())
                .first()
            total += getPriority(same)
        }

        println(total)
    }

    println("part1")
    part1()

    fun part2() {
        var total = 0
        for (line in readInput("Day03").chunked(3)) {
            val common = line[0]
                .toSet()
                .intersect(line[1].toSet())
                .intersect(line[2].toSet())
                .first()
            total += getPriority(common)
        }

        println(total)
    }

    println("part2")
    part2()
}