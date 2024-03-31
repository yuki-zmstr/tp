package storage;
import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class StorageTest {

    ArrayList<Recipe> recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;
    Storage storage;

    public StorageTest() {
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
        this.storage = new Storage("test_data/test_recipes.txt");
    }

    @Test
    public void testSaving(){
        recipes.add(testRecipe);
        try {
            Storage.saveFile(recipes);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
