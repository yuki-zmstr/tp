package recipeio;

import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;
import recipeio.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RecipeIOTest {

    RecipeList recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;

    Storage storage = new Storage("test_data/test_recipes.txt");

    public RecipeIOTest() {
        this.recipes = new RecipeList(storage.loadData());
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
        assertEquals("Cream Spaghetti / added on 2024-03-20 / url: www.spaghetti.com", testRecipe.toString());
    }

}
