fun main() {
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
    testCase4(solution)
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charMap = HashMap<Char, Int>()
        var biggestLength: Int = 0
        var currentLength: Int = 0
        var startIndex: Int = 0
        //search through a window inside the string search for the biggest string without character reptition. 
        //each time a reptition is found, clear the founded characters map and start counting again
        for(ch in s.iterator()) {
            currentLength = 0
            for(endIndex in startIndex..s.length - 1) {
                
                val ch2 = s.get(endIndex)

                if(charMap.containsKey(ch2)) {
                    charMap.clear()
                    break
                } else {
                    currentLength++
                    charMap.put(ch2, endIndex)
                }
            }
            startIndex++
            biggestLength = if(currentLength > biggestLength) currentLength else biggestLength


        }

        return if(currentLength > biggestLength) currentLength else biggestLength  
    }
}


fun testCase1(solution: Solution) { 
    val result = solution.lengthOfLongestSubstring("abcabcbb")
    println(result)
    assertTest(
        testName = "Test 1",
        expectedOutput = 3,
        solutionOutput = result
    )
    
}

fun testCase2(solution: Solution) { 
    val result = solution.lengthOfLongestSubstring("bbbbb")
    println(result)
    assertTest(
        testName = "Test 2",
        expectedOutput = 1,
        solutionOutput = result
    )
}

fun testCase3(solution: Solution) { 
    val result = solution.lengthOfLongestSubstring("pwwkew")
    println(result)
    assertTest(
        testName = "Test 3",
        expectedOutput = 3,
        solutionOutput = result
    )
}

fun testCase4(solution: Solution) { 
    val result = solution.lengthOfLongestSubstring("au")
    println(result)
    assertTest(
        testName = "Test 4",
        expectedOutput = 2,
        solutionOutput = result
    )
}

fun assertTest(testName: String, expectedOutput: Int, solutionOutput: Int) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }