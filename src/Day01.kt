fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

    val numberList = input.map { it.toInt() }
    var num = numberList.first()
    var increased = 0

    for (next in numberList) {

        if (next > num) {
            increased++
            num = next

        } else {
            num = next
        }
    }

    println(increased)
}
