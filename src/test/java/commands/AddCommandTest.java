package commands;

import org.junit.jupiter.api.Test;
import recipeio.InputParser;
import recipeio.commands.AddRecipeCommand;
import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static recipeio.enums.MealCategory.DINNER;

public class AddCommandTest {
    public static final String MULTIPLE_ALLERGY_PARAM_INPUT = "add pizza, 34, 340, dairy egg, dinner, www.url.com";
    public static final String MISSING_NAME_PARAM_INPUT = "add 34, 340, dairy egg, dinner, www.url.com";
    public static final String MISSING_TIME_PARAM_INPUT = "add pizza, 340, dairy egg, dinner, www.url.com";
    public static final String MISSING_KCAL_PARAM_INPUT = "add pizza, 34, dairy egg, dinner, www.url.com";
    public static final String MISSING_ALLERGY_PARAM_INPUT = "add pizza, 34, 340, dinner, www.url.com";
    public static final String MISSING_MEAL_CAT_PARAM_INPUT = "add pizza, 34, 340, dairy egg, www.url.com";
    public static final String MISSING_URL_PARAM_INPUT = "add pizza, 34, 340, dairy egg, dinner";
    ArrayList<Recipe> recipes = new ArrayList<>();

    @Test
    public void testMultipleAllergyParseAdd() {
        recipes.clear();
        Recipe testRecipe = InputParser.parseAdd(MULTIPLE_ALLERGY_PARAM_INPUT);
        ArrayList<String> allergies = new ArrayList<>();
        allergies.add("dairy");
        allergies.add("egg");
        Recipe expectedParsedRecipe = new Recipe(
                "pizza",
                34,
                340,
                allergies,
                DINNER,
                LocalDate.now(),
                "www.url.com");
        AddRecipeCommand.execute(testRecipe, recipes);
        assertEquals(recipes.size(), 1);
        assertEquals(testRecipe.allergies.size(), 2);
        assertEquals(testRecipe.toString(), expectedParsedRecipe.toString());
        assertEquals(testRecipe.name, expectedParsedRecipe.name);
        assertEquals(testRecipe.cookTime, expectedParsedRecipe.cookTime);
        assertEquals(testRecipe.calories, expectedParsedRecipe.calories);
        assertEquals(testRecipe.allergies, expectedParsedRecipe.allergies);
        assertEquals(testRecipe.category, expectedParsedRecipe.category);
        assertEquals(testRecipe.dateAdded, expectedParsedRecipe.dateAdded);
        assertEquals(testRecipe.url, expectedParsedRecipe.url);
    }
}
