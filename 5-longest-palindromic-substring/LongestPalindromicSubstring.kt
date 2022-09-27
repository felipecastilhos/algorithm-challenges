fun main() { 
    val solution = Solution()
    testCase1(::longestPalindrome)
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
fun longestPalindrome(s: String): String {
        var longestSize = 0
        var currentSize = 0


        for(startIndex in 0..s.length-1) {
            for(endIndex in s.length-1 downto 0) {
                    if(s.get[startIndex] == s.get[endIndex]) {
                       currentSize++
                    }
            }

            longestSize = max(longestSize, currentSize)
        }
}

fun testCase1(solution: (String) -> String) {
    val input = "babad"
    val expectedOutput = "aba"
    val solutionOutput = solution.invoke(input)
    println(solutionOutput)
    assertTest(
        testName = "Teste 1",
        expectedOutput = expectedOutput, 
        solutionOutput =  solutionOutput
    )
}

fun assertTest(testName: String, expectedOutput: Double, solutionOutput: Double) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }

