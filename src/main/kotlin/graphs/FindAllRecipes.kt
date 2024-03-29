package graphs
/**
 * [2115. Find All Possible Recipes from Given Supplies](https://leetcode
 * .com/problems/find-all-possible-recipes-from-given-supplies)
 *
 * @Difficulty=
 */
class FindAllRecipes {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val recipeMap = recipes.zip(ingredients).toMap()
        val unlimitedSupplies = supplies.toMutableSet()
        val result = mutableSetOf<String>()

        fun canCook(visiting: MutableSet<String>, recipe: String): Boolean {
            if(recipe in unlimitedSupplies) return true
            if(recipe !in recipeMap) return false
            for(ingredient in recipeMap[recipe] ?: emptyList()) {
                if(ingredient in unlimitedSupplies) continue
                if(ingredient in visiting) return false
                visiting.add(ingredient)
                if(!canCook(visiting, ingredient)) return false
                visiting.remove(ingredient)
            }
            unlimitedSupplies.add(recipe)
            return true
        }

        for(recipe in recipes) {
            if(recipe in unlimitedSupplies) result.add(recipe)
            if(canCook(mutableSetOf(), recipe)) result.add(recipe)
        }

        return result.toList()
    }
}
// Solution
/**
 * @Time_Complexity=O(V + E) Vertices and Edges.
 */
