package inputparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import recipeio.InputParser;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;

public class InputParserTest {

    ArrayList<Recipe> recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;

    public InputParserTest() {
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
    public void parseID_idGiven_expectIdReturned() {
        String userInput = "details 1";
        Assertions.assertEquals(1, InputParser.parseID(userInput));
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
}
