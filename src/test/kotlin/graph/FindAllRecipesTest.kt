package graph

import graphs.FindAllRecipes
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindAllRecipesTest {

    private val subject = FindAllRecipes()

    @Test
    fun goodExampleToLearn() {
        val recipes: Array<String> = arrayOf("burger", "sandwich", "bread")
        val ingredients: List<List<String>> = listOf(
            listOf("sandwich","meat" ,"bread"),listOf("bread","meat"),listOf("yeast","flour"))

        val supplies: Array<String> = arrayOf("yeast","flour","meat")

        val result = subject.findAllRecipes(recipes, ingredients, supplies)

        assertEquals(recipes.toList(),result)
    }
}