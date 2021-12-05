fun main() {
    fun part1(input: List<String>): Int {
        //Solution by Kotlin by JetBrains YouTube Advent of Code 2021 in Kotlin, Day 2: Dive!
        var depth = 0  // Initialize to 0 because our sub starts at default position 0 on y axis.
        var horizontalPosition = 0 // Initialize to 0 because our sub starts at default position 0 on x axis.
        // Next iterate over each line, and split each element with a space. Then store the result of this 
        // iteration in a variable.
        //Inside map we have an intercept variable called it, which refers to each specific line.
        // Then call split on the string, and split each element by a space.
        val operations = input.map { it.split(' ') }
        // Next iterate over each operation itself, like direction up or down. 
        // Then we'll change to the horizontal positions accordingly. for ((operations, ) in operations)
        // for (operations in operations) to for ((operations, ) in operations)
        // We can use destruction declaration to get first and second element of each list inside our operations.
        // First element refers to direction, and the second element refers to amount.
        for ((direction, amountString) in operations) {
            // But the amount is in a string, and we should operate with an integer for the value, because depth
            // and horizontal axis operate on integers.
            // Create a new variable called amount to store the converted Int amount.
            val amount = amountString.toInt()
            // Now we'll use the when expression to define what we should do for each existing direction.
            when(direction) {
                "up" -> depth -= amount // If the direction is up we should decrease depth by amount.
                "down" -> depth += amount // If the direction is down we should increase depth by amount.
                // If direction is forward we should increase the horizontalPostition by amount
                "forward"->horizontalPosition += amount


            }
        }
        // The last thing to do is return the depth * horizontalPosition
        return depth * horizontalPosition
    // Now test to see if our algorithm is correct
    // We know if our test doesn't fail then it doesn't work, comment out // println(part2(input))
    // ?copy the test data into Day02.txt and Day02_test.txt?
        //forward 5
        //down 5
        //forward 8
        //up 3
        //down 8
        //forward 2
    // so change test input to -1 because we know that it shouldn't be -1, should throw an exception.
    // reset the test number to 150, should return 0
    // Now copy in  the valid data into Day02.txt, and run.  Should get 1459206
    }

    fun part2(input: List<String>): Int {
        //Solution by Kotlin by JetBrains YouTube Advent of Code 2021 in Kotlin, Day 2: Dive!
        // From Creating Part2 Check below
        // Implement Part 2, Copy part1() to part2().
        // Then add one more variable named aim. And initialize to a default position of 0.
        var aim = 0
        var depth = 0
        var horizontalPosition = 0
        // Handle the input in the same way, we still use the operations variable,
        // but need to redefine what up, down, and forward do.
        val operations = input.map { it.split(' ') }
        for ((direction, amountString) in operations) {

            val amount = amountString.toInt()
            when(direction) {
                "up" -> aim -= amount // Change depth to aim
                "down" -> aim += amount // Change depth to aim
                // Forward now does a second operation, depth.
                // Add Curly braces. Assign depth to amount * aim
                // If we run from here, we get an error, because we have not increased depth, but reassigned it.
                // Set depth to increase by amount * aim. GOTO // println(part2(input))
                "forward" -> {
                    horizontalPosition += amount
                    depth += amount * aim
                }
            }
        }

        return depth * horizontalPosition // Should be 1320534480
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    //uncomment println(part2(input))
    println(part2(input))

    // PART 2 First thing to do is use kotlin standard library check function to create a test.
    // Check if part2 code input will give us 900
    // It should throw an exception because Part2 has not been implemented yet. GOTO fun part2()
    check(part2(testInput) == 900)
}
/* Solution by JCarlesVilaseca 12/2/21 r/adventofcode
 fun part1(input: Iterable<String>): Int {
     return input
         .fold(object { var x = 0; var depth = 0 }) {
                 position, command -> val action = command.split(' ')
             val value = action[1].toInt()

             when (action[0]) {
                 "forward" -> position.x += value
                 "down" -> position.depth += value
                 "up" -> position.depth -= value
             }
             position
         } .let {
             it.x * it.depth
         }
 }
 */





/*
    fun part2(input: Iterable<String>): Int {
        return input
            .fold(object { var x = 0; var depth = 0; var aim = 0 }) {
                    position, command -> val action = command.split(' ')
                val value = action[1].toInt()
                when (action[0]) {
                    "forward" -> {
                        position.x += value
                        position.depth += position.aim * value
                    }
                    "down" -> position.aim += value
                    "up" -> position.aim -= value
                }
                position
            } .let {
                it.x * it.depth
            }
    }
*/