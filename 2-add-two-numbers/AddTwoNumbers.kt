fun main() { 
    val solution = Solution()
    testCase1(solution)
    testCase2(solution)
    testCase3(solution)
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
        /**
        * Sum every element in the linked list, if the number is bigger than 9 add a carrier number for the next sum iteration 
         */
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var l1Iterator: ListNode? = l1
            var l2Iterator: ListNode? = l2
            var digit1 = l1Iterator?.`val` ?: 0
            var digit2 =  l2Iterator?.`val` ?: 0
            var sum = digit1 + digit2
            var carrier = 0
            var result = if(sum > 9) {
                carrier = 1
                ListNode (sum % 10)
            } else {
                ListNode (sum)
            }
           
            var current: ListNode? = result
            while(l1Iterator?.next != null|| l2Iterator?.next != null || carrier != 0) {
                l1Iterator = l1Iterator?.next
                l2Iterator = l2Iterator?.next
                digit1 = l1Iterator?.`val` ?: 0
                digit2 = l2Iterator?.`val` ?: 0
                sum = digit1 + digit2 + carrier
                
                var next =  if(sum > 9) {
                                carrier = 1
                                ListNode(sum % 10)
                            } else {
                                carrier = 0
                                ListNode(sum)
                            }
                
                current?.next = next
                current = current?.next
            } 
            return result
    }
}


data class ListNode(var `val`: Int) {
    var next: ListNode? = null
    fun printNumber() {
        print("[")
        printNumber(this)
        print("]\n")
    }

    private fun printNumber(listNode: ListNode?) {
        if(listNode == null) return
        print("${listNode.`val`}")
        if(listNode.next != null ) {
            print(",")
            printNumber(listNode.next)
        }
    }

    fun equalsNode(listNode: ListNode?): Boolean {
        return if(this.`val` == listNode?.`val`) {
            if(this.next == null) true
            else this.next?.equalsNode(listNode.next) ?: false
        } else {
            false
        }
    }
}


private fun testCase1(solution: Solution) { 
    val inputArray1 = createNumberListNodes(intArrayOf(9,9,9,9,9,9,9))
    val inputArray2 = createNumberListNodes(intArrayOf(9,9,9,9))

    val expectedOutput = createNumberListNodes(intArrayOf(8,9,9,9,0,0,0,1))
    val solutionOutput = solution.addTwoNumbers(inputArray1, inputArray2)

    assertTest(
        testName = "Teste 1", 
        expectedOutput = expectedOutput, 
        solutionOutput = solutionOutput
    )
}

private fun testCase2(solution: Solution) {
    val inputArray1 = createNumberListNodes(intArrayOf(0))
    val inputArray2 = createNumberListNodes(intArrayOf(7,3))

    val expectedOutput = createNumberListNodes(intArrayOf(7,3))
    val solutionOutput = solution.addTwoNumbers(inputArray1, inputArray2)

    assertTest(
        testName = "Teste 2", 
        expectedOutput = expectedOutput, 
        solutionOutput = solutionOutput
    )
}

private fun testCase3(solution: Solution) { 
    val inputArray1 = createNumberListNodes(intArrayOf(9,9,9,9))
    val inputArray2 = createNumberListNodes(intArrayOf(9,9,9,9,9,9,9))

    val expectedOutput = createNumberListNodes(intArrayOf(8,9,9,9,0,0,0,1))
    val solutionOutput = solution.addTwoNumbers(inputArray1, inputArray2)

    assertTest(
        testName = "Teste 3", 
        expectedOutput = expectedOutput, 
        solutionOutput = solutionOutput
    )
}

private fun assertTest(testName: String, expectedOutput: ListNode?, solutionOutput: ListNode?) { 
    if(expectedOutput?.equalsNode(solutionOutput) ?: false) { 
        printPassingMessage(testName) 
    }
    else {
        printFailingMessage(testName)
    }
}

private fun printPassingMessage(testName: String) { println("$testName: Pass") }
private fun printFailingMessage(testName: String) { println("$testName: Fail") }

private fun createNumberListNodes(array: IntArray): ListNode? { 
    var resultListNode: ListNode? = null
    var current: ListNode? = null
    array.forEach { 
            if(resultListNode == null) { 
                resultListNode = ListNode(it)
                current = resultListNode
            } else { 
                current?.next = ListNode(it)
                current = current?.next
            }
    }
    return resultListNode
}
