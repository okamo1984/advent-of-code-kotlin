fun main() {
    println("part1")

    fun part1() {

        fun getStrategy(s: String) = when (s) {
            "A", "X" -> Strategy.Rock
            "B", "Y" -> Strategy.Paper
            "C", "Z" -> Strategy.Scissors
            else -> throw Error()
        }

        var totalScore = 0
        for (line in readInput("Day02")) {
            val (opponent, me) = line.split(" ")
            val myStrategy = getStrategy(me)
            val opponentStrategy = getStrategy(opponent)
            totalScore += myStrategy.playRound(opponentStrategy)
        }

        println(totalScore)
    }

    part1()

    println("part2")

    fun part2() {
        fun getStrategy(s: String) = when (s) {
            "A" -> Strategy.Rock
            "B" -> Strategy.Paper
            "C" -> Strategy.Scissors
            else -> throw Error()
        }

        fun getResult(s: String) = when (s) {
            "X" -> Strategy.Result.WIN
            "Y" -> Strategy.Result.DRAW
            "Z" -> Strategy.Result.LOSE
            else -> throw Error()
        }

        var totalScore = 0
        for (line in readInput("Day02")) {
            val (opponent, me) = line.split(" ")
            val result = getResult(me)
            val opponentStrategy = getStrategy(opponent)
            val myStrategy = opponentStrategy.getAppropriateStrategyFromResult(result)
            totalScore += myStrategy.playRound(opponentStrategy)
        }

        println(totalScore)
    }

    part2()
}

sealed class Strategy {

    abstract val baseScore: Int
    abstract fun play(opponent: Strategy): Result
    abstract fun getAppropriateStrategyFromResult(result: Result): Strategy

    fun playRound(opponent: Strategy): Int {
        return play(opponent).score + baseScore
    }

    enum class Result(val score: Int) {
        WIN(6),
        LOSE(0),
        DRAW(3)
        ;
    }

    object Rock : Strategy() {
        override val baseScore = 1
        override fun play(opponent: Strategy) = when (opponent) {
            Rock -> Result.DRAW
            Paper -> Result.LOSE
            Scissors -> Result.WIN
        }

        override fun getAppropriateStrategyFromResult(result: Result) = when (result) {
            Result.WIN -> Scissors
            Result.LOSE -> Paper
            Result.DRAW -> Rock
        }
    }

    object Paper : Strategy() {
        override val baseScore = 2
        override fun play(opponent: Strategy) = when (opponent) {
            Rock -> Result.WIN
            Paper -> Result.DRAW
            Scissors -> Result.LOSE
        }

        override fun getAppropriateStrategyFromResult(result: Result) = when (result) {
            Result.WIN -> Rock
            Result.LOSE -> Scissors
            Result.DRAW -> Paper
        }
    }

    object Scissors : Strategy() {
        override val baseScore = 3
        override fun play(opponent: Strategy) = when (opponent) {
            Rock -> Result.LOSE
            Paper -> Result.WIN
            Scissors -> Result.DRAW
        }

        override fun getAppropriateStrategyFromResult(result: Result) = when (result) {
            Result.WIN -> Paper
            Result.LOSE -> Rock
            Result.DRAW -> Scissors
        }
    }
}