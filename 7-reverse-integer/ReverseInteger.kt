
fun main() {
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
}

class Solution {
    fun reverse(x: Int): Int {
        var variableX = x
        var reverse = 0L

        while(variableX != 0) {
            val lastDigit = variableX % 10
            reverse = reverse * 10 + lastDigit
            variableX /= 10
        }

        if(reverse >= Int.MIN_VALUE && reverse <= Int.MAX_VALUE){
            return reverse.toInt()
        } else {
            return 0
        }
    }
}

fun testCase1(solution: Solution) {  
    val input = 123
    val expectedOutput = 321
    val solutionOutput = solution.reverse(input)

    assertTest(
        testName = "Teste 1",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}

fun testCase2(solution: Solution) {  
    val input = -123
    val expectedOutput = -321
    val solutionOutput = solution.reverse(input)

    assertTest(
        testName = "Teste 2",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}

fun testCase3(solution: Solution) {  
    val input = 120
    val expectedOutput = 21
    val solutionOutput = solution.reverse(input)

    assertTest(
        testName = "Teste 3",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}



fun assertTest(testName: String, expectedOutput: Int, solutionOutput: Int) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }

