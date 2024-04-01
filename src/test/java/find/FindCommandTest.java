package find;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import recipeio.Constants;
import recipeio.commands.FindCommand;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class FindCommandTest {
    private ArrayList<Recipe> recipes;
    private ArrayList<String> allergies;

    private Recipe testRecipe;
    public FindCommandTest() {
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
        recipes.add(this.testRecipe);

        this.testRecipe = new Recipe(
                "Pho",
                480,
                600,
                allergies,
                MealCategory.BREAKFAST,
                LocalDate.of(2024, 4, 1),
                "www.pho.com"
        );
        recipes.add(this.testRecipe);

        this.testRecipe = new Recipe(
                "Laksa",
                100,
                620,
                allergies,
                MealCategory.DINNER,
                LocalDate.of(2024, 4, 1),
                "www.laksa.com"
        );
        recipes.add(this.testRecipe);
    }

    @Test
    public void testFindByMealExistItem() {
        String command = Constants.TEST_FIND_BY_MEAL_EXIST_ITEM;
        String expected = "\tThese recipes have the category " + Constants.MEAL_CAT_BREAKFAST
                + System.lineSeparator()
                + "\t\t" + "Pho / added on 2024-04-01 / url: www.pho.com"
                + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.findByMeal(command, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByMealNotExistItem() {
        String command = Constants.TEST_FIND_BY_MEAL_NOT_EXIST_ITEM;
        String expected = "\tThere's no recipe with category dessert" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.findByMeal(command, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInvalidMealCat() {
        String command = Constants.TEST_FIND_BY_INVALID_MEAL;
        String expected = "Invalid meal category!" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.findByMeal(command, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }
}
