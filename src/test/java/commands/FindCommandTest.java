package commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import recipeio.commands.FindCommand;
import recipeio.commands.FindDate;
import recipeio.commands.FindKeyword;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;



public class FindCommandTest {
    public static final String COMMAND_INVALID_MEAL_CAT = "find meal fdjsjfsad";
    public static final String COMMAND_EXIST_MEAL = "find meal breakfast";
    public static final String COMMAND_NOT_EXIST_MEAL = "find meal Appetizer";
    public static final String COMMAND_VALID_URL = "find url www.food.com";
    public static final String COMMAND_INVALID_URL = "find url food.com";
    public static final String COMMAND_INVALID_DOMAIN = "find url www.food";
    public static final String COMMAND_VALID_URL_WITH_PATH = "find url www.food.com/spaghetti";
    public static final String COMMAND_VALID_URL_WITH_INCOMPLETE_PATH = "find url www.food.com/spaghe";
    public static final String COMMAND_VALID_URL_WITHOUT_MATCH = "find url www.food.com/meatballs";
    public static final String COMMAND_VALID_URL_WITHOUT_PATH = "find url www.food.com/";
    public static final String COMMAND_DIFFERENT_PROTOCOL = "find url https://food.net";
    public static final String COMMAND_VALID_URL_NUMERIC_PATH = "find url www.food.com/123/com";
    public static final String COMMAND_INVALID_TOP_LEVEL_DOMAIN = "find url www.food.c";
    private ArrayList<Recipe> recipes;
    private ArrayList<String> allergies;
    private Recipe testRecipe;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


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
    public void testFindByKeywordExist() {
        System.setOut(new PrintStream(outContent));
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Cream Spaghetti", 60, 500, null,
                null, LocalDate.of(2024, 3, 20), "www.food.com/spaghetti"));
        recipes.add(new Recipe("Pho", 480, 600, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com/pho"));
        recipes.add(new Recipe("Laksa", 100, 620, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com"));
        FindKeyword.execute("Spaghetti", recipes);
        assertTrue(outContent.toString().contains("Here are your matches with keyword: Spaghetti"));
        assertTrue(outContent.toString().contains("Cream Spaghetti"));
        assertFalse(outContent.toString().contains("Pho"));
        System.setOut(originalOut);
    }

    @Test
    public void testFindByKeywordNotExist() {
        System.setOut(new PrintStream(outContent));
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Cream Spaghetti", 60, 500, null,
                null, LocalDate.of(2024, 3, 20), "www.food.com/spaghetti"));
        recipes.add(new Recipe("Pho", 480, 600, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com/pho"));
        recipes.add(new Recipe("Laksa", 100, 620, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com"));
        FindKeyword.execute("Burger", recipes);
        assertTrue(outContent.toString().contains("There were no matches. Try searching for something else. "));
        System.setOut(originalOut);
    }
    @Test
    public void testFindByDateExist() {
        System.setOut(new PrintStream(outContent));
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Cream Spaghetti", 60, 500, null,
                null, LocalDate.of(2024, 3, 20), "www.food.com/spaghetti"));
        recipes.add(new Recipe("Pho", 480, 600, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com/pho"));
        recipes.add(new Recipe("Laksa", 100, 620, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com"));
        FindDate.execute(LocalDate.of(2024, 4, 1), recipes);
        assertTrue(outContent.toString().contains("Pho"));
        assertTrue(outContent.toString().contains("Laksa"));
        assertFalse(outContent.toString().contains("Cream Spaghetti"));
        System.setOut(originalOut);
    }

    @Test
    public void testFindByDateNotExist() {
        System.setOut(new PrintStream(outContent));
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Cream Spaghetti", 60, 500, null,
                null, LocalDate.of(2024, 3, 20), "www.food.com/spaghetti"));
        recipes.add(new Recipe("Pho", 480, 600, null,
                null, LocalDate.of(2024, 4, 1), "www.food.com/pho"));
        recipes.add(new Recipe("Laksa", 100, 620,
                null, null, LocalDate.of(2024, 4, 1), "www.food.com"));
        FindDate.execute(LocalDate.of(2024, 5, 1), recipes);
        assertTrue(outContent.toString().contains("There were no matches. Try searching for something else. "));
        System.setOut(originalOut);
    }
    @Test
    public void testFindByMealExistItem() {
        String expected = "These recipes have the category: breakfast\n"
                + System.lineSeparator()
                + "Recipe 2. Pho / 600 kcals / 480 mins / added on 2024-04-01 / url: www.food.com/pho"
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
                "Recipe 1. Cream Spaghetti / 500 kcals / 60 mins / added on 2024-03-20 / url: www.food.com/spaghetti" +
                System.lineSeparator() +
                "Recipe 2. Pho / 600 kcals / 480 mins / added on 2024-04-01 / url: www.food.com/pho" +
                System.lineSeparator() +
                "Recipe 3. Laksa / 620 kcals / 100 mins / added on 2024-04-01 / url: www.food.com" +
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
                "Recipe 1. Cream Spaghetti / 500 kcals / 60 mins / added on 2024-03-20 / url: www.food.com/spaghetti" +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_WITH_PATH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidDomain() {
        String expected = "URL domain name or TLD is invalid." +
                System.lineSeparator() +
                "Example: \"www.food.com\" or \" https://www.example.com\" " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_INVALID_DOMAIN, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidURLIncompletePath() {
        String expected = "There were no matches. Try searching for something else. " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_WITH_INCOMPLETE_PATH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidURLWithoutMatch() {
        String expected = "There were no matches. Try searching for something else. " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_WITHOUT_MATCH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidURLWithoutPath() {
        String expected = "There were no matches. Try searching for something else. " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_WITHOUT_PATH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentProtocol() {
        String expected = "There were no matches. Try searching for something else. " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_DIFFERENT_PROTOCOL, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }
    @Test
    public void testNumericPath() {
        String expected = "There were no matches. Try searching for something else. " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_VALID_URL_NUMERIC_PATH, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testTLD() {
        String expected = "URL domain name or TLD is invalid." +
                System.lineSeparator() +
                "Example: \"www.food.com\" or \" https://www.example.com\" " +
                System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        FindCommand.execute(COMMAND_INVALID_TOP_LEVEL_DOMAIN, recipes);

        String actual = testOut.toString();

        assertEquals(expected, actual);
    }
}


