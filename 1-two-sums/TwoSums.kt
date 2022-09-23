fun main() { 
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
}

//Saves the result diff between the diff value and the current index into a dictionary if has no entry with the checked number as key, 
//if the has entry then we found the second number
//Eg.: Input: [3,2,4]; Target: 6
// 6-3 = 3 //saves the 3 as key and the current index, because has no entry as a key
// 6-2 = 4 // saves 4 and current index, because has no 4 entry as a key
// 6-4 = 2 // has 4 as key
// so return the current index(1) and the 4 key entry index(2)
    
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
      var result = intArrayOf( 0,0 )
      val resultMap = HashMap<Int, Int>()
    
      for(i in 0 until nums.size) {
        val number = nums[i]
        val diff = target - number
        if(!resultMap.containsKey(number)) {
            resultMap.set(diff, i)
        } else { 
            result[0] = resultMap.get(number) ?: 0
            result[1] = i
            break
        }
      }
        return result
    }
}

private fun testCase1(solution: Solution) {
    val result = solution.twoSum(
        nums = intArrayOf(2,7,11,15),
        target = 9
    )

    assertTest(
        testName = "Test 1",
        value = result, 
        expected = intArrayOf(0,1)
        )
}

private fun testCase2(solution: Solution) {
    val result = solution.twoSum(
        nums = intArrayOf(3,2,4),
        target = 6
    )

    assertTest(
        testName = "Test 2",
        value = result, 
        expected = intArrayOf(1,2)
        )
}


fun testCase3(solution: Solution) {

    val result = solution.twoSum(
        nums = intArrayOf(3,3),
        target = 6
    )

    assertTest(
        testName = "Test 3",
        value = result, 
        expected = intArrayOf(0,1)
        )
}

private fun assertTest(testName: String, value: IntArray, expected: IntArray) { 
    if(value contentEquals expected) { 
        printPassingMessage(testName) 
    }
    else {
        printFailingMessage(testName)
    }
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }
