package recipeio;

import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
                "Cream Spaghetti",
                60,
                500,
                allergies,
                MealCategory.LUNCH,
                "www.spaghetti.com"
        );
    }

    @Test
    public void parseID_idGiven_expectIdReturned() {
        String userInput = "details 1";
        assertEquals(1, InputParser.parseID(userInput));
    }

    @Test
    public void parseID_idNotGiven_expectNullReturned() {
        String userInput = "details ";
        assertNull(InputParser.parseID(userInput));
    }

    @Test
    public void parseID_stringGiven_expectNullReturned() {
        String userInput = "details abc";
        assertNull(InputParser.parseID(userInput));
    }

    @Test
    public void isWithinRange_idOutOfBounds_expectFalseReturned() {
        recipes.add(dummyRecipe);
        int testInput = 2;
        assertFalse(CommandValidator.isWithinRange(recipes, testInput));
    }
}
