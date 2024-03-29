package recipeio;

import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    ArrayList<Recipe> recipes;
    ArrayList<String> allergies;
    Recipe dummyRecipe;

    public InputParserTest() {
        this.recipes = new ArrayList<>();
        this.allergies = new ArrayList<>();
        allergies.add("eggs");
        allergies.add("dairy");
        this.dummyRecipe = new Recipe(
                "Spaghetti Carbonara",
                60,
                500,
                allergies,
                MealCategory.LUNCH,
                "www.carbonara.com"
        );
    }

    @Test
    public void parseID_IdGiven_expectIdReturned() {
        String userInput = "details 1";
        assertEquals(1, InputParser.parseID(userInput));
    }

    @Test
    public void parseID_IdNotGiven_expectNullReturned() {
        String userInput = "details ";
        assertNull(InputParser.parseID(userInput));
    }

    @Test
    public void parseID_stringGiven_expectNullReturned() {
        String userInput = "details abc";
        assertNull(InputParser.parseID(userInput));
    }

    @Test
    public void isWithinRange_IdOutOfBounds_expectFalseReturned() {
        recipes.add(dummyRecipe);
        int testInput = 2;
        assertFalse(Utils.isWithinRange(recipes, testInput));
    }
}
