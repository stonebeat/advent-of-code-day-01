import kotlin.math.abs

fun main() {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    fun part1(): Int {
        var sum = 0

        for (i in 0..left.size - 1)
            sum += abs(left.get(i) - right.get(i))

        return sum
    }

    fun part2(): Int {
        var sum = 0
        val searchedNumbers = mutableMapOf<Int, Int>()

        for (l in left)
            sum += searchedNumbers.getOrPut(l) {
                right.count { it == l } * l
            }

        return sum
    }

    fun initListsLeftAndRight(input: List<String>) {
        left.clear()
        right.clear()

        for (line in input) {
            val leftAndRight = line.split(" +".toRegex())
            left.add(leftAndRight.get(0).toInt())
            right.add(leftAndRight.get(1).toInt())
        }

        right.sort()
        left.sort()
    }

    // Test if implementation meets criteria from the description, like:
    initListsLeftAndRight(readInput("Day01_test"))
    check(part1() == 11)
    check(part2() == 31)

    // Read the input from the `src/Day01.txt` file.
    initListsLeftAndRight(readInput("Day01"))

    part1().println()
    part2().println()
}
