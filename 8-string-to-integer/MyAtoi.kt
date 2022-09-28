
fun main() {
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
    testCase4(solution)
    testCase5(solution)
    testCase6(solution)
    testCase7(solution)
    testCase8(solution)
    testCase9(solution)
}

class Solution {
    fun myAtoi(s: String): Int {
        var isNegative: Boolean? = null
        var result = 0L
        var sIndex = 0
        var lastDigit: Char? = null
        
        while(sIndex < s.length) {
            val ch = s[sIndex]
            if(ch == ' ' && lastDigit == null) {
                sIndex++
                continue 
            } 
            if(ch == '-' || ch == '+') {
                if(isNegative == null && lastDigit == null) {
                    isNegative = ch == '-'
                    lastDigit = ch
                    sIndex++
                    continue
                } else return 0
            }
            else if(ch.isDigit()){
                lastDigit = ch
                result = result * 10 + ch.toString().toInt()
            } 
            else return result.asResult(isNegative)
            sIndex++
        }

        if(result >= Int.MAX_VALUE && !(isNegative ?: false) ) return Int.MAX_VALUE
        else if(isNegative ?: false && -result <= Int.MIN_VALUE ) return Int.MIN_VALUE
        
        return result.asResult(isNegative)
    }

    fun Long.asResult(isNegative: Boolean?): Int {
        val result = if(isNegative ?: false) {
            -this 
        } else this

        return result.toInt()
    }
}

fun testCase1(solution: Solution) {  
    val input = "42"
    val expectedOutput = 42
    val solutionOutput = solution.myAtoi(input)

    assertTest(
        testName = "Teste 1",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}

fun testCase2(solution: Solution) {  
    val input = "   -42"
    val expectedOutput = -42
    val solutionOutput = solution.myAtoi(input)

    assertTest(
        testName = "Teste 2",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}

fun testCase3(solution: Solution) {  
    val input = "4193 with words"
    val expectedOutput = 4193
    val solutionOutput = solution.myAtoi(input)

    assertTest(
        testName = "Teste 3",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}

fun testCase4(solution: Solution) {  
    val input = "words and 987"
    val expectedOutput = 0
    val solutionOutput = solution.myAtoi(input)

    assertTest(
        testName = "Teste 4",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )
}


fun testCase5(solution: Solution) {
    val input = "-91283472332"
    val expectedOutput = -2147483648
    val solutionOutput = solution.myAtoi(input)


    assertTest(
        testName = "Teste 5",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )   
}

fun testCase6(solution: Solution) { 
    val input = "+1"
    val expectedOutput = 1
    val solutionOutput = solution.myAtoi(input)


    assertTest(
        testName = "Teste 6",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )   
}

fun testCase7(solution: Solution) { 
    val input = "+-12"
    val expectedOutput = 0
    val solutionOutput = solution.myAtoi(input)


    assertTest(
        testName = "Teste 7",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )   
}

fun testCase8(solution: Solution) {
    val input = "00000-42a1234"
    val expectedOutput = 0
    val solutionOutput = solution.myAtoi(input)

    assertTest(
        testName = "Teste 8",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )  
}

fun testCase9(solution: Solution) {
    val input = "   +0 123"
    val expectedOutput = 0
    val solutionOutput = solution.myAtoi(input)

    println("$expectedOutput $solutionOutput")

    assertTest(
        testName = "Teste 9",
        expectedOutput = expectedOutput,
        solutionOutput = solutionOutput
    )  
}

fun assertTest(testName: String, expectedOutput: Int, solutionOutput: Int) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }

