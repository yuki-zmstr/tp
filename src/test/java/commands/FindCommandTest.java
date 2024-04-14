package commands;

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
    public static final String COMMAND_VALID_URL = "find url www.food.com";
    public static final String COMMAND_INVALID_URL = "find url food.com";
    public static final String COMMAND_VALID_URL_WITH_PATH = "find url www.food.com/spaghetti";
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
                "www.food.com/spaghetti"
        );
        recipes.add(this.testRecipe);

        this.testRecipe = new Recipe(
                "Pho",
                480,
                600,
                allergies,
                MealCategory.BREAKFAST,
                LocalDate.of(2024, 4, 1),
                "www.food.com/pho"
        );
        recipes.add(this.testRecipe);

        this.testRecipe = new Recipe(
                "Laksa",
                100,
                620,
                allergies,
                MealCategory.DINNER,
                LocalDate.of(2024, 4, 1),
                "www.food.com"
        );
        recipes.add(this.testRecipe);
    }

    @Test
    public void testFindByMealExistItem() {
        String expected = "These recipes have the category: breakfast\n"
                + System.lineSeparator()
                + "Recipe 2. Pho / added on 2024-04-01 / url: www.food.com/pho"
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
        String expected = "There's no recipe with category: appetizer" +
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
                + "Accepted meal categories are:" + System.lineSeparator()
                + "\tBreakfast" + System.lineSeparator()
                + "\tLunch" + System.lineSeparator()
                + "\tDinner" + System.lineSeparator()
                + "\tDessert" + System.lineSeparator()
                + "\tAppetizer" + System.lineSeparator()
                + "\tGeneral" + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_INVALID_MEAL_CAT, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidURL() {
        String expected = "Here are your matches with url:  www.food.com\n" +
                System.lineSeparator() +
                "Recipe 1. Cream Spaghetti / added on 2024-03-20 / url: www.food.com/spaghetti" +
                System.lineSeparator() +
                "Recipe 2. Pho / added on 2024-04-01 / url: www.food.com/pho" +
                System.lineSeparator() +
                "Recipe 3. Laksa / added on 2024-04-01 / url: www.food.com" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidURL() {
        String expected = "Make sure your URL starts with 'http://', 'https://', or 'www.'" + System.lineSeparator() +
                "Example: \"www.food.com\" or \" https://www.example.com\" " + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_INVALID_URL, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidURLPath() {
        String expected = "Here are your matches with url:  www.food.com/spaghetti\n" +
                System.lineSeparator() +
                "Recipe 1. Cream Spaghetti / added on 2024-03-20 / url: www.food.com/spaghetti" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_WITH_PATH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }
}


