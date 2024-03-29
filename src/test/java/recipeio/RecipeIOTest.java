package recipeio;

import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RecipeIOTest {

    RecipeList recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;

    public RecipeIOTest() {
        this.recipes = new RecipeList();
        this.allergies = new ArrayList<>();
        allergies.add("eggs");
        allergies.add("dairy");
        this.testRecipe = new Recipe(
                "Cream Spaghetti",
                60,
                500,
                allergies,
                MealCategory.LUNCH,
                "www.spaghetti.com"
        );
    }

    @Test
    public void testAddRecipe() {
        recipes.clear();
        recipes.add(testRecipe);
        assertEquals(1, recipes.getSize());
    }

    @Test
    public void testDeleteRecipe() {
        recipes.clear();
        recipes.add(testRecipe);
        recipes.delete(1);
        assertEquals(0, recipes.getSize());
    }

    @Test
    public void testStringConversion() {
        assertEquals("Cream Spaghetti / 60 min / 500 kcal / url: www.spaghetti.com", testRecipe.toString());
    }

}
