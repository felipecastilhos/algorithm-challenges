fun main() { 
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
    testCase4(solution)
    testCase5(solution)
    testCase6(solution)
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        val xString = x.toString()
        return isPalindrome(xString)
    }

    fun isPalindrome(x: String): Boolean {
        if(x.length <= 1) return true

        val startDigit = x[0]
        val endDigit = x[x.length-1]
        val isPalindrome = startDigit == endDigit 
        
        if(x.length == 2) return isPalindrome

        val substring = x.substring(1, x.length - 1)

        return isPalindrome && isPalindrome(substring)
    }
}

fun testCase1(solution: Solution) { 
    val nums1 = 121
    val solutionOutput = solution.isPalindrome(nums1)

    assertTest(
        testName = "Test 1",
        expectedOutput = true,
        solutionOutput = solutionOutput
    )
}

fun testCase2(solution: Solution) { 
    val nums1 = -121
    val solutionOutput = solution.isPalindrome(nums1)
    assertTest(
        testName = "Test 2",
        expectedOutput = false,
        solutionOutput = solutionOutput
    )
}

fun testCase3(solution: Solution) { 
    val nums1 = 10
    val solutionOutput = solution.isPalindrome(nums1)
    assertTest(
        testName = "Test 3",
        expectedOutput = false,
        solutionOutput = solutionOutput
    )
}

fun testCase4(solution: Solution) { 
    val nums1 = 11
    val solutionOutput = solution.isPalindrome(nums1)
    assertTest(
        testName = "Test 4",
        expectedOutput = true,
        solutionOutput = solutionOutput
    )
}

fun testCase5(solution: Solution) {
    val nums1 = 1000021
    val solutionOutput = solution.isPalindrome(nums1)
    assertTest(
        testName = "Test 5",
        expectedOutput = false,
        solutionOutput = solutionOutput
    )
}

fun testCase6(solution: Solution) {
    val nums1 = 1200021
    val solutionOutput = solution.isPalindrome(nums1)
    assertTest(
        testName = "Test 5",
        expectedOutput = false,
        solutionOutput = solutionOutput
    )
}

fun assertTest(testName: String, expectedOutput: Boolean, solutionOutput: Boolean) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }