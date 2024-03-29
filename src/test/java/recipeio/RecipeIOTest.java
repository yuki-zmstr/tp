package recipeio;

import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class RecipeIOTest {

    RecipeList recipes;
    ArrayList<String> allergies;
    Recipe dummyRecipe;

    public RecipeIOTest() {
        this.recipes = new RecipeList();
        this.allergies = new ArrayList<>();
        allergies.add("eggs");
        allergies.add("dairy");
        this.dummyRecipe = new Recipe(
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
        recipes.add(dummyRecipe);
        assertEquals(1, recipes.getSize());
    }

    @Test
    public void testDeleteRecipe() {
        recipes.add(dummyRecipe);
        recipes.delete(1);
        assertEquals(0, recipes.getSize());
    }
    
    @Test
    public void testStringConversion() {
        assertEquals("Cream Spaghetti / 60 min / 500 kcal / url: www.spaghetti.com", dummyRecipe.toString());
    }


    @Test
    public void testFindAllergy() {
        ArrayList<String> testAllergies = new ArrayList<>();
        testAllergies.add("eggs");
        Recipe testRecipe = new Recipe("Cream Spaghetti", 0, 0, testAllergies,
                MealCategory.LUNCH, null);
        assert testRecipe.allergies.toString().equals("[eggs]") : "correct allergy";
        RecipeList testRecipeList = new RecipeList();
        testRecipeList.add(testRecipe);
        testRecipeList.findAllergy("eggs");
        String expectedOutput = "List of recipes with eggs mentioned:\nCream Spaghetti\n";
        assertEquals(testRecipeList.findAllergy("eggs"), expectedOutput);
    }
}
