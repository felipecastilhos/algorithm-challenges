import java.util.Arrays

fun main() { 
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
}

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val mergedArraySize = nums1.size + nums2.size
            val isEven = mergedArraySize % 2 == 0
            val mergedArray = mutableListOf<Int>()
            var num1Iterator = 0
            var num2Iterator = 0
            var median: Double
            for(i in 0..mergedArraySize-1) { 
                val nums1HasElements = nums1.size - num1Iterator > 0
                val nums2HasElements = nums2.size - num2Iterator > 0

                if(!nums1HasElements) {
                    mergedArray.add(nums2[num2Iterator])
                    num2Iterator++
                } else if(!nums2HasElements) {
                    mergedArray.add(nums1[num1Iterator])
                    num1Iterator++
                } else if(nums1HasElements && nums2HasElements) {
                    if(nums1[num1Iterator] < nums2[num2Iterator]) {
                        mergedArray.add(nums1[num1Iterator])
                        num1Iterator++
                    } else { 
                        mergedArray.add(nums2[num2Iterator])
                        num2Iterator++
                    }
                }
            }

            if(isEven) {
                val half = (mergedArraySize -1)/2
                median = (mergedArray[half] + mergedArray[half + 1]) / 2.0
            } else {
                median = mergedArray[mergedArraySize / 2].toDouble()
            }

        return median
    }
}


fun testCase1(solution: Solution) { 
    val nums1 = intArrayOf(1,3)
    val nums2 = intArrayOf(2)
    val solutionOutput = solution.findMedianSortedArrays(nums1, nums2)
    assertTest(
        testName = "Test 1",
        expectedOutput = 2.0,
        solutionOutput = solutionOutput
    )
}

fun testCase2(solution: Solution) { 
    val nums1 = intArrayOf(1,2)
    val nums2 = intArrayOf(3,4)
    val solutionOutput = solution.findMedianSortedArrays(nums1, nums2)
    assertTest(
        testName = "Test 2",
        expectedOutput = 2.5,
        solutionOutput = solutionOutput
    )
}


fun assertTest(testName: String, expectedOutput: Double, solutionOutput: Double) { 
    if(expectedOutput == solutionOutput) printPassingMessage(testName) else printFailingMessage(testName)
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }