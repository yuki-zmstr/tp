import org.junit.jupiter.api.Test;
import recipeio.commands.AddRecipeCommand;
import recipeio.commands.DeleteRecipeCommand;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecipeIOTest {

    ArrayList<Recipe> recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;

    public RecipeIOTest() {
        this.recipes = new ArrayList<>();
        this.allergies = new ArrayList<>();
        allergies.add("eggs");
        allergies.add("dairy");
        this.testRecipe = new Recipe(
                "Cream Spaghetti",
                60,
                500,
                allergies,
                MealCategory.LUNCH,
                LocalDate.of(2024, 3, 20),
                "www.spaghetti.com"
        );
    }

    @Test
    public void testAddRecipe() {
        recipes.clear();
        AddRecipeCommand.execute(testRecipe, recipes);
        assertEquals(1, recipes.size());
    }

    @Test
    public void testDeleteRecipe() {
        recipes.clear();
        recipes.add(testRecipe);
        DeleteRecipeCommand.execute(1, recipes);
        assertEquals(0, recipes.size());
    }

    @Test
    public void testStringConversion() {
        assertEquals("Cream Spaghetti / added on 2024-03-20 / url: www.spaghetti.com", testRecipe.toString());
    }

}
