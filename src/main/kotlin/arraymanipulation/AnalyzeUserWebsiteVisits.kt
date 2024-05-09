package arraymanipulation

/**
 * [1152. Analyze User Website Visit Pattern](https://leetcode.com/problems/analyze-user-website-visit-pattern/description)
 *
 * @Difficulty=Medium
 *
 * You are given two string arrays username and website and an integer array timestamp. All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]] indicates that the user username[i] visited the website website[i] at time timestamp[i].
 *
 * A pattern is a list of three websites (not necessarily distinct).
 *
 * For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
 * The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.
 *
 * For example, if the pattern is ["home", "away", "love"], the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
 * Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
 * Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number of users x such that x visited "luffy" three different times at different timestamps.
 * Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.
 *
 *
 *
 * Example 1:
 *
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation: The tuples in this example are:
 * ["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],["james","maps",6],["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
 * The pattern ("home", "about", "career") has score 2 (joe and mary).
 * The pattern ("home", "cart", "maps") has score 1 (james).
 * The pattern ("home", "cart", "home") has score 1 (james).
 * The pattern ("home", "maps", "home") has score 1 (james).
 * The pattern ("cart", "maps", "home") has score 1 (james).
 * The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).
 * Example 2:
 *
 * Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
 * Output: ["a","b","a"]
 */
class AnalyzeUserWebsiteVisits {
    data class Visit(val site: String, val time: Int)

    fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
        // For each user, build a list of site/timestamp visit combos
        val userVisits = mutableMapOf<String, MutableList<Visit>>()
        for (i in 0 until username.size) {
            userVisits.getOrPut(username[i]) {
                mutableListOf()
            }.add(Visit(website[i], timestamp[i]))
        }

        // Now build each pattern of sites {s1, s2, s3} from these user
        // visits, ordered by the timestamp. Use this pattern as a key
        // and add the user to the set of users that performed that pattern.
        val patterns = mutableMapOf<String, MutableSet<String>>()
        userVisits.forEach { (user, v) ->
            val sites = v.sortedBy { it.time }.map { it.site }
            for (i in 0..v.size-3) {
                for (j in i+1..v.size-2) {
                    for (k in j+1..v.size-1) {
                        val key = "${sites[i]},${sites[j]},${sites[k]}"
                        patterns.getOrPut(key) { mutableSetOf() }.add(user)
                    }
                }
            }
        }
        // Finally figure out the most common pattern (max set of users)
        val maxVal = patterns.values.maxByOrNull { it.size }?.size ?: 0
        // Get all patterns that had this count
        val maxPatterns = patterns.keys.filter { patterns[it]!!.size == maxVal }
        // And return the lexicographically smallest as a list of sites.
        return maxPatterns.minByOrNull { it }?.split(",") ?: listOf()
    }
}
// Solution
/**
 * @Time_Complexity= Combining all parts, the overall time complexity is:
 * O(n) + O(u * m log m) + O(u * m^3) + O(p) + O(p log p)
 *
 * n: Total number of visits.
 * u: Number of unique users.
 * m: Max number of visits by any user.
 * p: Number of unique patterns.
 */
