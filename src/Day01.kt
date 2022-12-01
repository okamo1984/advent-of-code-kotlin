import java.io.File

fun main() {
    println("part1")
    part1()

    println("part2")
    part2()
}

fun part1() {
    // https://kotlination.com/read-file-kotlin/
    val bufferedReader = File("src", "Day01.txt").bufferedReader()
    bufferedReader.use {
        var max = 0
        var candidate = 0
        while (true) {
            val line = it.readLine()?.trim { char -> char == '\n' || char == '\r' } ?: break
            if (line != "") {
                candidate += line.toInt()
            } else {
                if (candidate > max) {
                    max = candidate
                }
                candidate = 0
            }
        }
        if (candidate > max) {
            max = candidate
        }
        println(max)
    }
}

fun part2() {
    val bufferedReader = File("src", "Day01.txt").bufferedReader()
    bufferedReader.useLines {lines ->
        val calories = mutableListOf<Int>()
        var sum = 0
        for (line in lines) {
            val calorie = line.trim { char -> char == '\n' || char == '\r' }
            if (calorie != "") {
                sum += calorie.toInt()
            } else {
                calories.add(sum)
                sum = 0
            }
        }
        val top3 = calories.sortedDescending().slice(0..2)
        println(top3.sum())
    }
}