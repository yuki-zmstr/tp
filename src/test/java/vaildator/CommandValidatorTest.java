package vaildator;

import org.junit.jupiter.api.Test;
import recipeio.CommandValidator;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommandValidatorTest {
    ArrayList<Recipe> recipes;
    ArrayList<String> allergies;
    Recipe testRecipe;

    public CommandValidatorTest() {
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

    /**
     * Tests if a parameter is a valid meal category.
     */
    @Test
    public void isMealCat_validInput_expectTrue() {
        String test = "breakfast";
        assertTrue(CommandValidator.isMealCat(test));
    }

    @Test
    public void isMealCat_invalidInput_expectFalse() {
        String test = "drink";
        assertFalse(CommandValidator.isMealCat(test));
    }

    /**
     * Tests if a parameter is within the range of recipes.
     */
    @Test
    public void isWithinRange_idWithinBounds_expectTrue() {
        recipes.clear();
        recipes.add(testRecipe);
        int testInput = 1;
        assertTrue(CommandValidator.isWithinRange(recipes, testInput));
    }

    @Test
    public void isWithinRange_idOutOfBounds_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        int testInput = 2;
        assertFalse(CommandValidator.isWithinRange(recipes, testInput));
    }

    /**
     * Tests if a detail command is valid.
     */
    @Test
    public void isValidDetailCommand_idOutOfBounds_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail 2";
        assertFalse(CommandValidator.isValidDetailCommand(testInput, recipes));
    }

    @Test
    public void isValidDetailCommand_noIndexGiven_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail";
        assertFalse(CommandValidator.isValidDetailCommand(testInput, recipes));
    }

    @Test
    public void isValidDetailCommand_stringGivenAsParameter_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail abc";
        assertFalse(CommandValidator.isValidDetailCommand(testInput, recipes));
    }

    @Test
    public void isValidDetailCommand_validCommand_expectTrue() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail 1";
        assertTrue(CommandValidator.isValidDetailCommand(testInput, recipes));
    }

    /**
     * Tests if a delete command is valid.
     */
    @Test
    public void isValidDeleteCommand_idOutOfBounds_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail 2";
        assertFalse(CommandValidator.isValidDeleteCommand(testInput, recipes));
    }

    @Test
    public void isValidDeleteCommand_noIndexGiven_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "delete";
        assertFalse(CommandValidator.isValidDeleteCommand(testInput, recipes));
    }

    @Test
    public void isValidDeleteCommand_stringGivenAsParameter_expectFalse() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "delete abc";
        assertFalse(CommandValidator.isValidDeleteCommand(testInput, recipes));
    }

    @Test
    public void isValidDeleteCommand_validCommand_expectTrue() {
        recipes.clear();
        recipes.add(testRecipe);
        String testInput = "detail 1";
        assertTrue(CommandValidator.isValidDeleteCommand(testInput, recipes));
    }

    /**
     * Tests if an add command is valid.
     */
    @Test
    public void isValidAddCommand_validCommand_expectTrue() {
        String test = "add pizza, 34, 340, egg nut dairy gluten, dinner, www.food.com";
        assertTrue(CommandValidator.isValidAddCommand(test));
    }

    @Test
    public void isValidAddCommand_invalidCommand_expectFalse() {
        String test = "add pizza, abc, 340, egg nut dairy gluten, dinner, www.food.com";
        assertFalse(CommandValidator.isValidAddCommand(test));
    }

}
