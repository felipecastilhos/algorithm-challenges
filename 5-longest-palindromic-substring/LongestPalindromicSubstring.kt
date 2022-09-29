fun main() { 
    testCase1(::longestPalindrome)
    testCase2(::longestPalindrome)
    testCase3(::longestPalindrome, true)
}

/**
*Given a string s, return the longest palindromic substring in s.
*
*A string is called a palindrome string if the reverse of that string is the same as the original string.
*
*
*
*Example 1:
*
*Input: s = "babad"
*Output: "bab"
*Explanation: "aba" is also a valid answer.
*Example 2:
*
*Input: s = "cbbd"
*Output: "bb"
*
 */
fun longestPalindrome(s: String, debug: Boolean = false): String {
    var n = s.length
    var i = 0

    if(n == 1) return s
    val str = s.reversed()

    if(str == s) return s

    var minStart = 0
    var maxLength = 1

    while(i < n) {
        if(n - i <= maxLength / 2) break
        var j = i
        var k = i

        while(k < n-1 && s[k+1] == s[k]) ++k

        i = k+1
        while(k < n-1 && j > 0 && s[k + 1] == s[j - 1]) { 
            ++k
            --j
        }

        val newLength = k - j + 1

        if(newLength > maxLength) {
            minStart = j 
            maxLength = newLength
        }
    }

    return s.substring(minStart, maxLength)

}

fun logDebug(message: String, debug: Boolean, newLine: Boolean = true) {
    if(debug) {
        if(newLine) println(message)
        else print(message)
    }
}

fun testCase1(solution: (String, Boolean) -> String, debug: Boolean = false) {
    val input = "babad"
    val expectedOutput = "bab"
    val solutionOutput = solution.invoke(input, debug)
    println("$expectedOutput $solutionOutput")

    assertTest(
        testName = "Teste 1",
        expectedOutput = expectedOutput, 
        solutionOutput =  solutionOutput
    )
}

fun testCase2(solution: (String, Boolean) -> String, debug: Boolean = false) {
    val input = "cbbd"
    val expectedOutput = "bb"
    val solutionOutput = solution.invoke(input, debug)
    println("$expectedOutput $solutionOutput")
    assertTest(
        testName = "Teste 2",
        expectedOutput = expectedOutput, 
        solutionOutput =  solutionOutput
    )
}

fun testCase3(solution: (String, Boolean) -> String, debug: Boolean = false) {
    val input = "aacabdkacaa"
    val expectedOutput = "aca"
    val solutionOutput = solution.invoke(input, debug)
    println("$expectedOutput $solutionOutput")
    assertTest(
        testName = "Teste 3",
        expectedOutput = expectedOutput, 
        solutionOutput =  solutionOutput
    )
}


fun assertTest(testName: String, expectedOutput: String, solutionOutput: String) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }

