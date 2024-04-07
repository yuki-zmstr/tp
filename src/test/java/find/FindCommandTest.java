package find;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import recipeio.commands.FindCommand;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class FindCommandTest {
    //Test find commands
    public static final String COMMAND_INVALID_MEAL_CAT = "find meal fdjsjfsad";
    public static final String COMMAND_EXIST_MEAL = "find meal breakfast";
    public static final String COMMAND_NOT_EXIST_MEAL = "find meal Appetizer";
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
        String expected = "\tThese recipes have the category breakfast"
                + System.lineSeparator()
                + "\t\t" + "Pho / added on 2024-04-01 / url: www.pho.com"
                + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_EXIST_MEAL, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindByMealNotExistItem() {
        String expected = "\tThere's no recipe with category appetizer" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_NOT_EXIST_MEAL, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInvalidMealCat() {
        String expected = "Invalid meal category!" + System.lineSeparator()
                + "\tAccepted meal categories are:" + System.lineSeparator()
                + "\t\tBreakfast" + System.lineSeparator()
                + "\t\tLunch" + System.lineSeparator()
                + "\t\tDinner" + System.lineSeparator()
                + "\t\tDessert" + System.lineSeparator()
                + "\t\tAppetizer" + System.lineSeparator()
                + "\t\tGeneral" + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_INVALID_MEAL_CAT, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }
}
