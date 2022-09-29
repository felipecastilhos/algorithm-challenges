fun main() { 
    val solution = Solution() 
    testCase1(solution)
}

class Solution {
    fun convert(s: String, numRows: Int): String {
        var rowIterator = 0
        var rowIncrement = 1
        
        var dictionary = HashMap<Int, String>()
        s.forEach { ch ->
            val entry = dictionary[rowIterator] ?: ""
            dictionary.set(rowIterator, "$entry$ch")
            if(rowIterator  == numRows - 1) rowIncrement = -1
            else if(rowIterator == 0)  rowIncrement = 1
                          
            rowIterator += rowIncrement
        }
        
        var resultString = ""
        dictionary.forEach {key, value->
            resultString += value
            dictionary.set(key, value)
        }
        return resultString
    }
}

fun testCase1(solution: Solution) { 
    val inputString = "PAYPALISHIRING"
    val inputNumRows = 3
    val expectedOutput = "PAHNAPLSIIGYIR"
    val solutionOutput = solution.convert(inputString, inputNumRows)

    println("$expectedOutput $solutionOutput")
    assertTest(
        testName = "Teste1",
        expectedOutput = expectedOutput, 
        solutionOutput = solutionOutput
    )
}

fun testCase2(solution: Solution) { 
    
} 

fun assertTest(testName: String, expectedOutput: String, solutionOutput: String) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }