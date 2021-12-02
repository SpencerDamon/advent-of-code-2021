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

    fun makeListOfInts(): List<Int> {
        return input.map { it.toInt() }
    }

    fun dayOnePartOne(): Int {
        val numberList = makeListOfInts()
        var num = numberList.first()
        var increased = 0

        for (next in numberList) {

            if (next > num) {
                increased++
            }

            num = next
        }


        return increased
    }


    println("\nDay one task 1: ${dayOnePartOne()}")
    // END OF DAY 1 TASK 1

    fun dayOnePartTwo(): Int {
        val numberList = makeListOfInts()
        val newNumList = mutableListOf<Int>()
        val listSizeMinus2 = numberList.size - 2

        for (i in numberList.indices) {
            if (i < listSizeMinus2) {
                newNumList.add(numberList[i] + numberList[i + 1] + numberList[i + 2])
            }
        }

        println()
        //println(newNumList)
        var num = newNumList.first()
        var increase = 0

        for (next in newNumList) {
            if (next > num) {
                increase++
            }

            num = next
        }

        return increase
    }

    println("\nDay one task 2: ${dayOnePartTwo()}")
}












