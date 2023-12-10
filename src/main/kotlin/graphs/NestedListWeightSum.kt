package graphs
/**
 * [339. Nested List Weight Sum](https://leetcode.com/problems/nested-list-weight-sum/description/)
 *
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 *
 * @Difficulty=
 */
class NestedListWeightSum {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * class NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     constructor()
     *
     *     // Constructor initializes a single integer.
     *     constructor(value: Int)
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     fun isInteger(): Boolean
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     fun getInteger(): Int?
     *
     *     // Set this NestedInteger to hold a single integer.
     *     fun setInteger(value: Int): Unit
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     fun add(ni: NestedInteger): Unit
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     fun getList(): List<NestedInteger>?
     * }
     */
//    fun depthSum(nestedList: List<NestedInteger>): Int {
//        return dfs(nestedList, 1)
//    }
//
//    fun dfs(nestedList: List<NestedInteger>, depth: Int): Int {
//        var total = 0
//        nestedList.forEach { integerOrList ->
//            if(integerOrList.getInteger() != null) {
//                total += integerOrList.getInteger() * depth
//            } else {
//                total += dfs(integerOrList.getList()!!, depth + 1)
//            }
//        }
//        return total
//    }
}
// Solution
/**
 * @Time_Complexity=O(n) n = number of nested integers.
 */